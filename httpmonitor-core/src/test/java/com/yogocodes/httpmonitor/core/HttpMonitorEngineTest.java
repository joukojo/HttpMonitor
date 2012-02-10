package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;

public class HttpMonitorEngineTest {

	@Test
	public void testHttpMonitorEngine() {

		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		assertNotNull("targets are not initialized", monitorEngine.targets);
		assertTrue("targets are not empty", monitorEngine.targets.isEmpty());
	}

	@Test
	public void testGetTargets() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		assertEquals("targets via method are different", monitorEngine.targets, monitorEngine.getTargets());

	}

	@Test
	public void testStart() {
		final List<HttpMonitorEngineWorker> expectedWorkers = new ArrayList<HttpMonitorEngineWorker>();
		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
		expectedWorkers.add(worker);

		final MonitorTarget target = new MonitorTarget();
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine() {
			@Override
			protected void initThreadPool(final int numberOfRequestedThreads) {
				assertEquals("the thread count is wrong", 1, numberOfRequestedThreads);

			}

			@Override
			protected List<HttpMonitorEngineWorker> createWorkers() {
				return expectedWorkers;
			}

			@Override
			protected void startTheWorkers(final List<HttpMonitorEngineWorker> workers) {
				assertEquals("workers are changed", expectedWorkers, workers);
			}
		};

		monitorEngine.getTargets().add(target);

		monitorEngine.start();

	}

	@Test
	public void testStop() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();
		monitorEngine.setRunning(true);
		monitorEngine.stop();
		Assert.assertFalse("the engine is still running even stopped", monitorEngine.isRunning());

	}

	@Test
	public void testIsRunning() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		monitorEngine.setRunning(true);

		assertTrue("engine is not running", monitorEngine.isRunning());

		monitorEngine.setRunning(false);

		Assert.assertFalse("engine is still running", monitorEngine.isRunning());

	}

	@Test
	public void testSetRunning() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		monitorEngine.setRunning(true);

		assertTrue("engine is not running", monitorEngine.isRunning());

		monitorEngine.setRunning(false);

		Assert.assertFalse("engine is still running", monitorEngine.isRunning());

	}

	@Test
	public void testStartTheWorkers() {
		final ExecutorService executorServiceMock = EasyMock.createMock(ExecutorService.class);
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine() {
			@Override
			public ExecutorService getExecutorService() {
				// TODO Auto-generated method stub
				return executorServiceMock;
			}
		};

		final List<HttpMonitorEngineWorker> workers = new ArrayList<HttpMonitorEngineWorker>();
		final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
		executorServiceMock.execute(worker);

		workers.add(worker);
		EasyMock.replay(executorServiceMock);
		monitorEngine.startTheWorkers(workers);
		EasyMock.verify(executorServiceMock);
	}

	@Test
	public void testCreateWorkers() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		final List<MonitorTarget> targets = new ArrayList<MonitorTarget>();

		for (int i = 0; i < 5; i++) {
			final MonitorTarget target = new MonitorTarget();
			targets.add(target);
		}

		monitorEngine.getTargets().addAll(targets);

		final List<HttpMonitorEngineWorker> workers = monitorEngine.createWorkers();

		assertNotNull("workers is null", workers);

		assertEquals("target count is defferent than worker count", targets.size(), monitorEngine.targets.size());

	}

	@Test
	public void testInitThreadPool() {
		final HttpMonitorEngine monitorEngine = new HttpMonitorEngine();

		final int numberOfRequestedThreads = 5;
		monitorEngine.initThreadPool(numberOfRequestedThreads);

		assertNotNull("executor service is null", monitorEngine.getExecutorService());

	}
}
