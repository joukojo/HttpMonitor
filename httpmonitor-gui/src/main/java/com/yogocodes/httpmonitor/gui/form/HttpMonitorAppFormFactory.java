package com.yogocodes.httpmonitor.gui.form;

import org.apache.commons.lang.builder.ToStringBuilder;

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
	 * Gets the shared application form instance. The method is thread safe.
	 * 
	 * @return shared form instance.
	 */
	public static HttpMonitorAppForm getAppFormInstance() {

		if (null == appFormInstance) {
			synchronized (HttpMonitorAppFormFactory.class) {
				if (null == appFormInstance) {
					appFormInstance = new HttpMonitorAppForm();

				}
			}
		}

		return appFormInstance;
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
