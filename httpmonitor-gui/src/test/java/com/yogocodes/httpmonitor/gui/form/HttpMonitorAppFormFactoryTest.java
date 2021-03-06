/**
 * 
 */
package com.yogocodes.httpmonitor.gui.form;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author joukojo
 * 
 */
public class HttpMonitorAppFormFactoryTest {

	@Test
	public void testGetAppFormInstance() {

		final HttpMonitorAppForm formInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		Assert.assertNotNull("form instance is null", formInstance);
		final HttpMonitorAppForm formInstance2 = HttpMonitorAppFormFactory.getAppFormInstance();
		Assert.assertNotNull("second call form instance is null", formInstance2);
		Assert.assertEquals("form instances does not match", formInstance, formInstance2);

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
