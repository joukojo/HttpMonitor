package com.yogocodes.httpmonitor.core;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpMonitorEngineWorker implements Runnable {

	private MonitorTarget target;

	@Override
	public void run() {
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory
				.getEngineInstance();

		final HttpClient httpClient = new HttpClient();
		final MonitorResultSummarizer summarizer = MonitorResultSummarizerFactory
				.getInstance();
		while (engineInstance.isRunning()) {
			final GetMethod method = new GetMethod(target.toString());

			try {
				final long start = System.currentTimeMillis();
				// FIXME add support for statuscode
				final int statusCode = httpClient.executeMethod(method);
				final long end = System.currentTimeMillis();

				final MonitorResult result = new MonitorResult();
				result.setUrl(target.toString());
				result.setTime((end - start));

				summarizer.addResult(result);
				Thread.sleep(1000);

			} catch (final HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

	}

	public void setValues(final MonitorTarget target) {
		this.target = target;
	}

}
