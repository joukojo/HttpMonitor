package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MonitorResultSummarizerFactoryTest {

	@Test
	public void testGetInstance() {
		final MonitorResultSummarizer instance = MonitorResultSummarizerFactory.getInstance();
		assertNotNull("instance is null", instance);
		final MonitorResultSummarizer instance2 = MonitorResultSummarizerFactory.getInstance();
		assertNotNull("instance is null", instance2);

		assertEquals("instance are different", instance, instance2);
	}

}
