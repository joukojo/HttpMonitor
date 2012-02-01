package com.yogocodes.httpmonitor.gui.form;

public class MonitorTargetFormFactory {
	
	private static MonitorTargetForm monitorTargetFormInstance;

	/**
	 * @return the monitorTargetFormInstance
	 */
	public static MonitorTargetForm getMonitorTargetFormInstance() {
		
		if( monitorTargetFormInstance == null ) {
			synchronized (MonitorTargetFormFactory.class) {
				if( monitorTargetFormInstance == null ){
					monitorTargetFormInstance = new MonitorTargetForm();
				}
			}
		}
		
		return monitorTargetFormInstance;
	}

	


}
