package com.yogocodes.httpmonitor.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Result container.
 * 
 * @author joukojo
 * 
 */
public class MonitorResult {

	private String url;
	private Long time;
	private Integer statusCode;
	private Integer numberOfBytes;
	private Long executeTime;

	/**
	 * Converts container to CSV line.
	 * 
	 * @return csv formatted line.
	 */
	public String toCSVLine() {
		final StringBuilder builder = new StringBuilder();

		final Date date = new Date(executeTime);
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

		builder.append(dateFormat.format(date));
		builder.append(',');
		builder.append(url);
		builder.append(',');
		builder.append(statusCode);
		builder.append(',');
		builder.append(time);
		builder.append(',');
		builder.append(numberOfBytes);
		builder.append(System.getProperty("line.separator"));

		return builder.toString();
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(final Long time) {
		this.time = time;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(final Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the numberOfBytes
	 */
	public Integer getNumberOfBytes() {
		return numberOfBytes;
	}

	/**
	 * @param numberOfBytes
	 *            the numberOfBytes to set
	 */
	public void setNumberOfBytes(final Integer numberOfBytes) {
		this.numberOfBytes = numberOfBytes;
	}

	/**
	 * @return the executeTime
	 */
	public Long getExecuteTime() {
		return executeTime;
	}

	/**
	 * @param executeTime
	 *            the executeTime to set
	 */
	public void setExecuteTime(final Long executeTime) {
		this.executeTime = executeTime;
	}

}
