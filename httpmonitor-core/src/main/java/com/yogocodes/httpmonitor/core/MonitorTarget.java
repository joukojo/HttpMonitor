package com.yogocodes.httpmonitor.core;

public class MonitorTarget {

	private String method;
	private String protocol;
	private String host;
	private int port;
	private String path;

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

}
