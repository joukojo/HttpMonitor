package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SystemPropertyContainerFactoryTest {

	@Test
	public void testGetContainerInstance() {
		final SystemPropertyContainer systemPropertyContainer = SystemPropertyContainerFactory.getContainerInstance();
		assertNotNull("isntance is null", systemPropertyContainer);
		final SystemPropertyContainer systemPropertyContainer2 = SystemPropertyContainerFactory.getContainerInstance();
		assertNotNull("isntance is null", systemPropertyContainer);

		assertEquals("instances differ", systemPropertyContainer, systemPropertyContainer2);
	}

}
