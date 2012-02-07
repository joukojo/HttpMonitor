package com.yogocodes.httpmonitor.core;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.TraceMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runnable class for running method in a separate thread.
 * 
 * @author joukojo
 * 
 */
public class HttpMonitorEngineWorker implements Runnable {

	private final static Logger LOG = LoggerFactory.getLogger(HttpMonitorEngineWorker.class);
	private MonitorTarget target;

	/**
	 * The run method for the worker.
	 * 
	 * @see HttpMonitorEngine monitor engine.
	 * @see MonitorResultSummarizer summarization of the results.
	 * @see MonitorLogWriter writing result log
	 * @see HttpMonitorEngine#isRunning() for getting the run flag.
	 */
	@Override
	public void run() {
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory.getEngineInstance();

		final HttpClient httpClient = new HttpClient();
		final MonitorResultSummarizer summarizer = MonitorResultSummarizerFactory.getInstance();

		final MonitorLogWriter writer = new MonitorLogWriter();
		while (engineInstance.isRunning()) {

			final HttpMethod method = createMethod(target);

			try {
				final long start = System.currentTimeMillis();

				final int statusCode = httpClient.executeMethod(method);
				int numOfBytes = 0;
				if (statusCode == 200) {
					final byte[] response = method.getResponseBody();
					numOfBytes = response.length;
				}
				final long end = System.currentTimeMillis();

				final MonitorResult result = new MonitorResult();
				result.setUrl(target.toString());
				result.setTime((end - start));
				result.setStatusCode(statusCode);
				result.setNumberOfBytes(numOfBytes);
				result.setExecuteTime(start);
				summarizer.addResult(result);
				writer.writeCSVLog(result);

			} catch (final HttpException e) {
				LOG.error("failed to create request to target:" + e.getMessage(), e);
			} catch (final IOException e) {
				LOG.error("failed to create request to target:" + e.getMessage(), e);
			}

			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				LOG.error("the thread sleep was interrupted, interruptting current one", e);
				Thread.currentThread().interrupt();
			}

		}

	}

	/**
	 * Creates a suitable method based on target
	 * 
	 * @param target
	 * @return HttpMethod for corresponding method.
	 * @see MonitorTarget#getMethod()
	 */

	protected HttpMethod createMethod(final MonitorTarget target) {
		if ("GET".equals(target.getMethod())) {
			return new GetMethod(target.toString());
		} else if ("POST".equals(target.getMethod())) {
			return new PostMethod(target.toString());
		} else if ("HEAD".equals(target.getMethod())) {
			return new HeadMethod(target.toString());
		} else if ("TRACE".equals(target.getMethod())) {
			return new TraceMethod(target.toString());
		} else if ("DELETE".equals(target.getMethod())) {
			return new DeleteMethod(target.toString());
		}

		return null;
	}

	/**
	 * Set the target for the worker.
	 * 
	 * @param target
	 *            monitor target
	 */
	public void setValues(final MonitorTarget target) {
		this.target = target;
	}

}
