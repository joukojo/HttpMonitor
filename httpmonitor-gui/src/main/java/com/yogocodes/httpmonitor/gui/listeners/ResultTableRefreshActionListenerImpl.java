package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.form.MonitorResult;
import com.yogocodes.httpmonitor.gui.form.MonitorResultTableModel;

public class ResultTableRefreshActionListenerImpl implements ActionListener {

	private final static Logger LOG = LoggerFactory.getLogger(ResultTableRefreshActionListenerImpl.class);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LOG.debug("refreshing result table"); 

		HttpMonitorAppForm appFormInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		
		MonitorResultTableModel tableModel = appFormInstance.getMonitorResultTableModel();
		
		MonitorResult result = new MonitorResult();
		result.setUrl("http://localhost/robots.txt");
		result.setTime(12345l); 
		tableModel.addResult(result );
		tableModel.fireTableDataChanged();
		LOG.debug("refreshed result table"); 
	}

}
