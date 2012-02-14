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
	protected MonitorTarget target;
	private HttpClient httpClient;

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

		final HttpClient httpClient = getHttpClient();
		final MonitorResultSummarizer summarizer = MonitorResultSummarizerFactory.getInstance();

		final MonitorLogWriter writer = createWriter();
		while (isRunning()) {

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
				LOG.error("failed to create request to target: '{}'" + e.getMessage(), target);
			} catch (final IOException e) {
				LOG.error("failed to create request to target: '{}'" + e.getMessage(), target);
			}

			try {
				if (target.getSleepPeriod() != null && target.getSleepPeriod() != 0l) {
					Thread.sleep(target.getSleepPeriod());
				} else {
					Thread.sleep(1000l);
				}

			} catch (final InterruptedException e) {
				LOG.error("the thread sleep was interrupted, interruptting current one", e);
				Thread.currentThread().interrupt();
			}

		}

	}

	protected MonitorLogWriter createWriter() {
		final MonitorLogWriter writer = new MonitorLogWriter();
		return writer;
	}

	protected boolean isRunning() {
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory.getEngineInstance();
		return engineInstance.isRunning();
	}

	protected HttpClient getHttpClient() {
		if (httpClient == null) {
			synchronized (HttpMonitorEngineWorker.class) {
				if (httpClient == null) {
					httpClient = new HttpClient();
				}
			}
		}

		return httpClient;
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
