/**
 * 
 */
package com.yogocodes.httpmonitor.gui.form;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

import com.yogocodes.httpmonitor.core.MonitorResultSummary;

/**
 * @author joukojo
 * 
 */
public class MonitorResultTableModelTest {

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#MonitorResultTableModel()}
	 * .
	 */
	@Test
	public void testMonitorResultTableModel() {
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		assertNotNull("results are null", tableModel.getResults());
		assertTrue("results are not empty", tableModel.getResults().isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#getColumnName(int)}
	 * .
	 */
	@Test
	public void testGetColumnNameInt() {
		final String[] header = { "url", "count", "delay", "average", "min", "max" };
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();
		for (int i = 0; i < header.length; i++) {
			final String actualColumnName = tableModel.getColumnName(i);
			Assert.assertEquals("column name does not match", header[i], actualColumnName);

		}
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#getRowCount()}
	 * .
	 */
	@Test
	public void testGetRowCount() {
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		Assert.assertEquals("size is different", 0, tableModel.getRowCount());

	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#getColumnCount()}
	 * .
	 */
	@Test
	public void testGetColumnCount() {
		final String[] header = { "url", "count", "delay", "average", "min", "max" };
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		Assert.assertEquals("column count is different", header.length, tableModel.getColumnCount());
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public void testGetValueAt() {
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		final MonitorResultSummary summary = createResultSummary();
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);

		for (int rowIndex = 0; rowIndex < tableModel.getRowCount(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
				final Object valueAt = tableModel.getValueAt(rowIndex, columnIndex);

				switch (columnIndex) {
				case 0:
					Assert.assertEquals("url is wrong", summary.getHost(), valueAt);
					break;

				case 1:
					Assert.assertEquals("number of requests are wrong", summary.getNumberOfRequests(), valueAt);
					break;
				case 2:
					Assert.assertEquals("time is wrong", summary.getTime(), valueAt);
					break;
				case 3:

					break;
				case 4:
					Assert.assertEquals("minimum time is wrong", summary.getMinTime(), valueAt);
					break;
				case 5:
					Assert.assertEquals("maximum time is wrong", summary.getMaxTime(), valueAt);
					break;
				default:
					Assert.fail("too many columns");
				}

			}
		}

	}

	/**
	 * @return
	 */
	private MonitorResultSummary createResultSummary() {
		final MonitorResultSummary summary = new MonitorResultSummary();
		final String expectedHost = "http://junit.localhost.com/junit/junit.html";
		final Long actualMaxTime = 4321L;
		final Long actualMinTime = 1l;
		final Integer actualNumberOfRequests = 12345;
		final Long actualTime = 432L;
		final Integer actualTotalTime = 4 * 432;

		summary.setHost(expectedHost);
		summary.setMaxTime(actualMaxTime);
		summary.setMinTime(actualMinTime);
		summary.setNumberOfRequests(actualNumberOfRequests);
		summary.setTime(actualTime);
		summary.setTotalTime(actualTotalTime);
		return summary;
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#clearData()}
	 * .
	 */
	@Test
	public void testClearData() {
		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		final MonitorResultSummary summary = createResultSummary();
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);
		tableModel.getResults().add(summary);

		Assert.assertFalse("table model is not empty", tableModel.getResults().isEmpty());
		tableModel.clearData();
		Assert.assertTrue("table model is not empty", tableModel.getResults().isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel#getResults()}
	 * .
	 */
	@Test
	public void testGetResults() {

		final MonitorResultTableModel tableModel = new MonitorResultTableModel();

		Assert.assertNotNull("results are null", tableModel);
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
