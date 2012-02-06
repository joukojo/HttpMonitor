package com.yogocodes.httpmonitor.core;

public class MonitorResultSummary {

	private String host;
	private long time;
	private int numberOfRequests = 1;
	private long maxTime = 0;
	private long minTime = Long.MAX_VALUE;
	private long totalTime;

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(final int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(final long maxTime) {
		this.maxTime = maxTime;
	}

	public long getMinTime() {
		return minTime;
	}

	public void setMinTime(final long minTime) {
		this.minTime = minTime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public long getTime() {
		return time;
	}

	public void setTime(final long time) {
		this.time = time;
	}

	/**
	 * @return the totalTime
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime
	 *            the totalTime to set
	 */
	public void setTotalTime(final long totalTime) {
		this.totalTime = totalTime;
	}

}
