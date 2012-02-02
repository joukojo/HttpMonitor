package com.yogocodes.httpmonitor.core;

public class HttpMonitorEngineFactory {

	private static HttpMonitorEngine engineInstance;

	public static HttpMonitorEngine getEngineInstance() {

		if (engineInstance == null) {
			synchronized (HttpMonitorEngineFactory.class) {
				if (engineInstance == null) {
					engineInstance = new HttpMonitorEngine();
				}
			}
		}

		return engineInstance;
	}

}
