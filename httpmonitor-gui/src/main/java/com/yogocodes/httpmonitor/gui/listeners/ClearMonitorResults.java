package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;

public class ClearMonitorResults implements ActionListener {

	private final HttpMonitorAppForm appForm;

	public ClearMonitorResults(final HttpMonitorAppForm httpMonitorAppForm) {
		this.appForm = httpMonitorAppForm;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.appForm.getMonitorResultTableModel().clearData();
		this.appForm.getMonitorResultTableModel().fireTableDataChanged();
	}

}
