package com.yogocodes.httpmonitor.core;

public class SystemPropertyContainer {

	private Long executionStartTime;
	private final String logFileName = "httpmonitor";

	public String getLogFileName() {
		return logFileName + "-" + executionStartTime + ".csv";
	}

	/**
	 * @return the executionStartTime
	 */
	public Long getExecutionStartTime() {
		return executionStartTime;
	}

	/**
	 * @param executionStartTime
	 *            the executionStartTime to set
	 */
	public void setExecutionStartTime(final Long executionStartTime) {
		this.executionStartTime = executionStartTime;
	}

}
