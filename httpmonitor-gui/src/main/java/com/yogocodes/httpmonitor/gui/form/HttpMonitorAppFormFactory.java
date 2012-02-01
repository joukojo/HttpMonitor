package com.yogocodes.httpmonitor.gui.form;

public class HttpMonitorAppFormFactory {

	
	private static HttpMonitorAppForm appFormInstance; 
	
	
	private HttpMonitorAppFormFactory() {
	
	}
	
	public static HttpMonitorAppForm getAppFormInstance() {
		
		if( appFormInstance == null ) {
			synchronized (HttpMonitorAppFormFactory.class) {
				if( appFormInstance == null ) {
					appFormInstance = new HttpMonitorAppForm(); 
					
				}
			}
		}
		
		
		return appFormInstance;
	}
	
}
