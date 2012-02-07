package com.yogocodes.httpmonitor.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpMonitor engine is class, which controls the worker threads. To
 * initialize, please use the factory.
 * 
 * @author joukojo
 * @See {@link HttpMonitorEngineFactory}
 * 
 */
public class HttpMonitorEngine {

	/**
	 * Engine's targets
	 */
	private final List<MonitorTarget> targets;

	/**
	 * The flag for indicating if the engine is running or not.
	 */
	private volatile boolean isRunning;

	/**
	 * Thread pool
	 */
	private ExecutorService executorService;
	private final static Logger LOG = LoggerFactory.getLogger(HttpMonitorEngine.class);

	/**
	 * Default constructor. For instantation {@link HttpMonitorEngineFactory}.
	 */
	protected HttpMonitorEngine() {
		targets = new ArrayList<MonitorTarget>();
	}

	/**
	 * Gets the targets.
	 * 
	 * @return the targets
	 */
	public List<MonitorTarget> getTargets() {
		return targets;
	}

	/**
	 * If the engine is not running, creates a thread pool and create workers
	 * for the all the jobs.
	 * 
	 * @see HttpMonitorEngineWorker
	 * @see SystemPropertyContainer
	 */
	public void start() {
		if (!isRunning) {
			LOG.debug("starting the monitor engine");
			isRunning = true;
			LOG.debug("creating thread pool {} threads", getTargets().size());
			executorService = Executors.newFixedThreadPool(getTargets().size());
			LOG.debug("storing the startup time");
			final SystemPropertyContainer containerInstance = SystemPropertyContainerFactory.getContainerInstance();
			containerInstance.setExecutionStartTime(System.currentTimeMillis());
			final List<HttpMonitorEngineWorker> workers = new ArrayList<HttpMonitorEngineWorker>();
			LOG.debug("creating workers for targets");
			for (final MonitorTarget target : getTargets()) {
				final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
				worker.setValues(target);
				workers.add(worker);
			}

			LOG.debug("exeuting workers");
			for (final HttpMonitorEngineWorker worker : workers) {
				executorService.execute(worker);
			}
			LOG.debug("exeuted workers");
		}

	}

	/**
	 * Stops the engine. Notice that the threads are requested stop nicely. So
	 * it's not instant.
	 */
	public void stop() {
		isRunning = false;
	}

	/**
	 * Gets the engine status
	 * 
	 * @return the isRunning true if the engine is active.
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Sets the engine status. Prefer the {@link #stop()} for requesting end of
	 * run.
	 * 
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(final boolean isRunning) {
		this.isRunning = isRunning;
	}

}
