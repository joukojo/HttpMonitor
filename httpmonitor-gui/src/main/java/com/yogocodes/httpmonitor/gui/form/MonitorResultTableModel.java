package com.yogocodes.httpmonitor.gui.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.table.AbstractTableModel;

import com.yogocodes.httpmonitor.core.MonitorResultSummary;

/**
 * MonitoResultTableModel for storing data to JList
 * 
 * @author joukojo
 * 
 * @see HttpMonitorAppForm#getMonitorResultTable()
 * @see JList
 */
public class MonitorResultTableModel extends AbstractTableModel {

	/**
	 * serial uid.
	 */
	private static final long serialVersionUID = 1L;
	private volatile List<MonitorResultSummary> results;
	private final String[] header = { "url", "count", "delay", "average", "min", "max" };

	/**
	 * Default constructor.
	 */
	public MonitorResultTableModel() {
		results = new ArrayList<MonitorResultSummary>();
	}

	@Override
	public String getColumnName(final int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {

		return getResults().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return header.length;
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {

		final MonitorResultSummary result = getResults().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return result.getHost();

		case 1:
			return result.getNumberOfRequests();
		case 2:
			return result.getTime();
		case 3:
			return result.getTotalTime() / result.getNumberOfRequests();
		case 4:
			return result.getMinTime();
		case 5:
			return result.getMaxTime();
		}
		return -1;
	}

	public void clearData() {
		getResults().clear();

	}

	/**
	 * @return the results
	 */
	public List<MonitorResultSummary> getResults() {
		return results;
	}

}
