package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SystemPropertyContainerTest {

	@Test
	public void testGetLogFileName() {

		final SystemPropertyContainer propertyContainer = new SystemPropertyContainer();

		final Long now = System.currentTimeMillis();
		propertyContainer.setExecutionStartTime(now);
		final String expected = "httpmonitor-" + now + ".csv";
		;
		assertEquals("logfilename is wrong", expected, propertyContainer.getLogFileName());

	}

	@Test
	public void testGetExecutionStartTime() {
		final SystemPropertyContainer propertyContainer = new SystemPropertyContainer();

		final Long now = System.currentTimeMillis();
		propertyContainer.setExecutionStartTime(now);

		final Long actual = propertyContainer.getExecutionStartTime();

		assertEquals("the executionstart time chages", now, actual);
	}

}
