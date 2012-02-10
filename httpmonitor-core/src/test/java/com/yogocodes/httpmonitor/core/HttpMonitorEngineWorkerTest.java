package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.easymock.EasyMock;
import org.junit.Test;

public class HttpMonitorEngineWorkerTest {

	@Test
	public void testRun() throws HttpException, IOException {
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory.getEngineInstance();
		final boolean isRunning = true;
		engineInstance.setRunning(isRunning);

		final HttpClient mockHttpClient = EasyMock.createMock(HttpClient.class);
		final GetMethod getMethod = EasyMock.createMock(GetMethod.class);
		EasyMock.expect(mockHttpClient.executeMethod(getMethod)).andReturn(200);
		final String response = "thahhahahahah";
		final byte[] responseBytes = response.getBytes();

		EasyMock.expect(getMethod.getResponseBody()).andReturn(responseBytes);
		final MonitorTarget actualTarget = new MonitorTarget();
		actualTarget.setSleepPeriod(1l);
		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker() {
			int callCount = 0;

			@Override
			protected HttpClient getHttpClient() {
				return mockHttpClient;
			}

			@Override
			protected HttpMethod createMethod(final MonitorTarget target) {
				return getMethod;
			}

			@Override
			protected boolean isRunning() {
				return callCount++ < 1;
			}

		};

		worker.setValues(actualTarget);
		EasyMock.replay(mockHttpClient, getMethod);
		worker.run();
		EasyMock.verify(mockHttpClient, getMethod);
	}

	@Test
	public void testGetHttpClient() {

		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();

		final HttpClient httpClient = worker.getHttpClient();
		assertNotNull("httpclient is null", httpClient);
		final HttpClient httpClient2 = worker.getHttpClient();
		assertNotNull("second call the httpclient is null", httpClient2);

		assertEquals("httpclient is not same one", httpClient, httpClient2);
	}

	@Test
	public void testCreateMethod() throws URIException {

		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
		final String methods[] = { "GET", "POST", "HEAD", "DELETE", "TRACE" };

		final MonitorTarget target = new MonitorTarget();
		target.setHost("localhost");

		target.setPath("junit.html");
		target.setPort(123);
		target.setProtocol("http");
		final String expectedUrl = target.toString();
		for (final String method : methods) {
			target.setMethod(method);

			final HttpMethod httpMethod = worker.createMethod(target);
			final URI uri = httpMethod.getURI();
			final String url = uri.toString();

			assertEquals("url is wrong", expectedUrl, url);

		}
	}

	@Test
	public void testSetValues() {
		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
		final MonitorTarget target = new MonitorTarget();
		worker.setValues(target);
		assertEquals("worker target is wrong", target, worker.target);
	}

}
