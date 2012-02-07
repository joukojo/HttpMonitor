package com.yogocodes.httpmonitor.core;

/**
 * HttpMonitorEngineFactory, which makes sure that there's only one instance
 * running.
 * 
 * @see HttpMonitorEngine
 * @author joukojo
 * 
 */
public class HttpMonitorEngineFactory {

	private static HttpMonitorEngine engineInstance;

	/**
	 * Creates only one shared instance for the engine Notice the method is
	 * thread safe.
	 * 
	 * @return shared engine instance.
	 */
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
