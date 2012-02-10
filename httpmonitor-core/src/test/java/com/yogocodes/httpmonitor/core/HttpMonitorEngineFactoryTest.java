package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * 
 * @author joukojo
 * 
 */
public class HttpMonitorEngineFactoryTest {

	@Test
	public void testGetEngineInstance() {
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory.getEngineInstance();

		assertNotNull("the engine instance is null", engineInstance);
		final HttpMonitorEngine engineInstance2 = HttpMonitorEngineFactory.getEngineInstance();
		assertNotNull("the second call the engine instance is null", engineInstance2);
		assertEquals("the engine instance is changed", engineInstance, engineInstance2);
	}

}
