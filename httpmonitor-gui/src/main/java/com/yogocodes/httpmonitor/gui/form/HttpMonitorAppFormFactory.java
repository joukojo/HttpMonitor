package com.yogocodes.httpmonitor.gui.form;

/**
 * Http Monitor form factory class
 * 
 * @author joukojo
 * 
 * 
 */
public class HttpMonitorAppFormFactory {

	private static HttpMonitorAppForm appFormInstance;

	/**
	 * use the {@link #getAppFormInstance()} to create instance.
	 */
	private HttpMonitorAppFormFactory() {

	}

	/**
	 * Gets the shared application form instance. The method is thread safe.
	 * 
	 * @return shared form instance.
	 */
	public static HttpMonitorAppForm getAppFormInstance() {

		if (appFormInstance == null) {
			synchronized (HttpMonitorAppFormFactory.class) {
				if (appFormInstance == null) {
					appFormInstance = new HttpMonitorAppForm();

				}
			}
		}

		return appFormInstance;
	}

}
