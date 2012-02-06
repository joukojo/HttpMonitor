package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.core.MonitorResultSummarizer;
import com.yogocodes.httpmonitor.core.MonitorResultSummarizerFactory;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;

public class ClearMonitorResults implements ActionListener {

	private final HttpMonitorAppForm appForm;

	public ClearMonitorResults(final HttpMonitorAppForm httpMonitorAppForm) {
		this.appForm = httpMonitorAppForm;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final MonitorResultSummarizer summarizer = MonitorResultSummarizerFactory
				.getInstance();
		summarizer.clearResults();
		this.appForm.getMonitorResultTableModel().clearData();
		this.appForm.getMonitorResultTableModel().fireTableDataChanged();
	}

}
