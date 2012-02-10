package com.yogocodes.httpmonitor.gui.form;

/**
 * MonitorTargetForm singleton factory.
 * 
 * @author joukojo
 * 
 */
public class MonitorTargetFormFactory {

	private static MonitorTargetForm monitorTargetFormInstance;

	/**
	 * Factory method to get the shared form instance.
	 * 
	 * @return the monitorTargetFormInstance
	 */
	public static MonitorTargetForm getMonitorTargetFormInstance() {

		if (monitorTargetFormInstance == null) {
			synchronized (MonitorTargetFormFactory.class) {
				if (monitorTargetFormInstance == null) {
					monitorTargetFormInstance = new MonitorTargetForm();
				}
			}
		}

		return monitorTargetFormInstance;
	}

}
