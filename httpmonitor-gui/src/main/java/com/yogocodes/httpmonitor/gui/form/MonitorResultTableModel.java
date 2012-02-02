package com.yogocodes.httpmonitor.gui.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.yogocodes.httpmonitor.core.MonitorResultSummary;

public class MonitorResultTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile List<MonitorResultSummary> results;
	private final String[] header = { "url", "delay" };

	public MonitorResultTableModel() {
		results = new ArrayList<MonitorResultSummary>();
	}

	@Override
	public String getColumnName(final int column) {
		return header[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
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
			return result.getTime();
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
