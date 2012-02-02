package com.yogocodes.httpmonitor.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpMonitorEngine {

	private final List<MonitorTarget> targets;

	private volatile boolean isRunning;

	private ExecutorService executorService;

	public HttpMonitorEngine() {
		targets = new ArrayList<MonitorTarget>();
	}

	/**
	 * @return the targets
	 */
	public List<MonitorTarget> getTargets() {
		return targets;
	}

	public void start() {
		if (!isRunning) {
			isRunning = true;

			executorService = Executors.newFixedThreadPool(getTargets().size());

			final List<HttpMonitorEngineWorker> workers = new ArrayList<HttpMonitorEngineWorker>();

			for (final MonitorTarget target : getTargets()) {
				final HttpMonitorEngineWorker worker = new HttpMonitorEngineWorker();
				worker.setValues(target);
				workers.add(worker);
			}

			for (final HttpMonitorEngineWorker worker : workers) {
				executorService.execute(worker);
			}

		}

	}

	public void stop() {
		isRunning = false;
	}

	/**
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(final boolean isRunning) {
		this.isRunning = isRunning;
	}

}
