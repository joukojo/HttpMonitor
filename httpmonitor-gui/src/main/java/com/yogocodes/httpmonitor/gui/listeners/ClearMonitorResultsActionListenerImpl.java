package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.core.MonitorResultSummarizer;
import com.yogocodes.httpmonitor.core.MonitorResultSummarizerFactory;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;

/**
 * Clear monitor results. All the counters are reset.
 * 
 * @author joukojo
 * 
 */
public class ClearMonitorResultsActionListenerImpl implements ActionListener {

	private final static Logger LOG = LoggerFactory.getLogger(ClearMonitorResultsActionListenerImpl.class);

	/**
	 * Default constructor
	 * 
	 * @param httpMonitorAppForm
	 */
	public ClearMonitorResultsActionListenerImpl() {

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		LOG.debug("getting instance for summarizer");
		final MonitorResultSummarizer summarizer = MonitorResultSummarizerFactory.getInstance();
		summarizer.clearResults();
		LOG.debug("cleared the results from summarizer");
		LOG.debug("clearing the gui");

		final HttpMonitorAppForm appFormInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		appFormInstance.getMonitorResultTableModel().clearData();
		appFormInstance.getMonitorResultTableModel().fireTableDataChanged();

		LOG.debug("cleared the gui");
	}

}
