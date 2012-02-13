package com.yogocodes.httpmonitor.core;

import java.util.Map;

public class MonitorTarget {

	private String method;
	private String protocol;
	private String host;
	private int port;
	private String path;

	private Map<String, String> headers;
	private Long sleepPeriod;

	public String getMethod() {
		return method;
	}

	public void setMethod(final String method) {
		this.method = method;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(final String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(final int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return protocol + "://" + this.host + ":" + port + "/" + path;
	}

	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers
	 *            the headers to set
	 */
	public void setHeaders(final Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * @return the sleepPeriod
	 */
	public Long getSleepPeriod() {
		return sleepPeriod;
	}

	/**
	 * @param sleepPeriod
	 *            the sleepPeriod to set
	 */
	public void setSleepPeriod(final Long sleepPeriod) {
		this.sleepPeriod = sleepPeriod;
	}

}
