package com.yogocodes.httpmonitor.gui.form;

import org.apache.commons.lang.builder.ToStringBuilder;

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

		if (null == monitorTargetFormInstance) {
			synchronized (MonitorTargetFormFactory.class) {
				if (null == monitorTargetFormInstance) {
					monitorTargetFormInstance = new MonitorTargetForm();
				}
			}
		}

		return monitorTargetFormInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("monitorTargetFormInstance", monitorTargetFormInstance);
		return builder.toString();
	}

}
