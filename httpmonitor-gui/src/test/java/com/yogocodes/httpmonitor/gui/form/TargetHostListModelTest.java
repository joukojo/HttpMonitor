/**
 * 
 */
package com.yogocodes.httpmonitor.gui.form;

import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.junit.Test;

import com.yogocodes.httpmonitor.core.MonitorTarget;

/**
 * @author joukojo
 * 
 */
public class TargetHostListModelTest {

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.TargetHostListModel#TargetHostListModel()}
	 * .
	 */
	@Test
	public void testTargetHostListModel() {

		final TargetHostListModel hostListModel = new TargetHostListModel();

		assertNotNull("monitorTargets are null", hostListModel.monitorTargets);
		Assert.assertTrue("results are empty", hostListModel.monitorTargets.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.TargetHostListModel#addTarget(com.yogocodes.httpmonitor.core.MonitorTarget)}
	 * .
	 */
	@Test
	public void testAddTarget() {
		final TargetHostListModel hostListModel = new TargetHostListModel();

		final MonitorTarget expectedTarget = new MonitorTarget();

		hostListModel.addTarget(expectedTarget);

		Assert.assertFalse("results are empty", hostListModel.monitorTargets.isEmpty());
		Assert.assertEquals("the result contains wrong result", expectedTarget, hostListModel.monitorTargets.get(0));
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.TargetHostListModel#getSize()}.
	 */
	@Test
	public void testGetSize() {
		final TargetHostListModel hostListModel = new TargetHostListModel();

		final MonitorTarget expectedTarget = new MonitorTarget();

		hostListModel.monitorTargets.add(expectedTarget);
		Assert.assertFalse("results are empty", hostListModel.monitorTargets.isEmpty());
		Assert.assertEquals("the result contains wrong result", expectedTarget, hostListModel.monitorTargets.get(0));

		Assert.assertEquals("the size is wrong", 1, hostListModel.getSize());

	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.TargetHostListModel#getElementAt(int)}
	 * .
	 */
	@Test
	public void testGetElementAt() {
		final TargetHostListModel hostListModel = new TargetHostListModel();

		final MonitorTarget expectedTarget = new MonitorTarget();

		hostListModel.monitorTargets.add(expectedTarget);
		Assert.assertFalse("results are empty", hostListModel.monitorTargets.isEmpty());
		Assert.assertEquals("the result contains wrong result", expectedTarget, hostListModel.monitorTargets.get(0));

		Assert.assertEquals("the element is wrong", expectedTarget, hostListModel.getElementAt(0));

	}

}
