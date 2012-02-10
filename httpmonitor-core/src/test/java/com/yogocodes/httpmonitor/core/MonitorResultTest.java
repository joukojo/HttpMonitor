package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class MonitorResultTest {

	@Test
	public void testToCSVLine() {
		final MonitorResult result = new MonitorResult();
		final long executeTime = 12345l;
		result.setExecuteTime(executeTime);
		final int numberOfBytes = 314158;
		result.setNumberOfBytes(numberOfBytes);
		final int statusCode = 200;
		result.setStatusCode(statusCode);
		final Long now = System.currentTimeMillis();
		result.setTime(now);
		final String url = "http://localhost/junit/junit.html";
		result.setUrl(url);

		final String actual = result.toCSVLine();
		final Date date = new Date(executeTime);

		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		final StringBuilder builder = new StringBuilder();
		builder.append(dateFormat.format(date));
		builder.append(',');
		builder.append(url);
		builder.append(',');
		builder.append(statusCode);
		builder.append(',');
		builder.append(now);
		builder.append(',');
		builder.append(numberOfBytes);
		builder.append(System.getProperty("line.separator"));

		final String expected = builder.toString();
		assertEquals("csv line is wrong", expected, actual);
	}
}
