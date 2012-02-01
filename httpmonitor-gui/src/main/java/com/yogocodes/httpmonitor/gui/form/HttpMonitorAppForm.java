/**
 * 
 */
package com.yogocodes.httpmonitor.gui.form;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.Timer;

import com.yogocodes.httpmonitor.gui.listeners.AddNewHostActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.EnableDisableButtonActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.ResultTableRefreshActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.StartMonitoringActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.StopMonitoringActionListenerImpl;

/**
 * @author joukojo
 * 
 */
public class HttpMonitorAppForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JButton addHostButton;
	private final JButton removeHostButton;
	private final JButton editHostButton;
	private final JTable monitorResultTable;
	private final MonitorResultTableModel monitorResultTableModel;
	private final JList monitoredHostList;
	private final JButton startMonitorButton;
	private final JButton stopMonitorButton;
	private final Timer resultTableRefreshTimer; 
	
	public HttpMonitorAppForm() {
		addHostButton = new JButton("Add");
		addHostButton.addActionListener(new AddNewHostActionListenerImpl());
		removeHostButton = new JButton("Remove");
		editHostButton = new JButton("Edit");
		monitorResultTableModel = new MonitorResultTableModel();
		monitorResultTable = new JTable();
		monitorResultTable.setModel(monitorResultTableModel);
		startMonitorButton = new JButton("Start");
		stopMonitorButton = new JButton("Stop");
		stopMonitorButton.setEnabled(false);
		String hosts[] = { "localhost:80/robots.txt" };
		monitoredHostList = new JList(hosts);
		EnableDisableButtonActionListenerImpl buttonListener = new EnableDisableButtonActionListenerImpl(startMonitorButton, stopMonitorButton);
		startMonitorButton.addActionListener(buttonListener);
		startMonitorButton.addActionListener(new StartMonitoringActionListenerImpl());
		stopMonitorButton.addActionListener(buttonListener);
		stopMonitorButton.addActionListener(new StopMonitoringActionListenerImpl());
		resultTableRefreshTimer = new Timer(500, new ResultTableRefreshActionListenerImpl());
	}

	/**
	 * @return the startMonitorButton
	 */
	public JButton getStartMonitorButton() {
		return startMonitorButton;
	}

	/**
	 * @return the stopMonitorButton
	 */
	public JButton getStopMonitorButton() {
		return stopMonitorButton;
	}

	/**
	 * @return the addHostButton
	 */
	public JButton getAddHostButton() {
		return addHostButton;
	}

	/**
	 * @return the removeHostButton
	 */
	public JButton getRemoveHostButton() {
		return removeHostButton;
	}

	/**
	 * @return the monitorResultTable
	 */
	public JTable getMonitorResultTable() {
		return monitorResultTable;
	}

	/**
	 * @return the editHostButton
	 */
	public JButton getEditHostButton() {
		return editHostButton;
	}

	/**
	 * @return the monitoredHostList
	 */
	public JList getMonitoredHostList() {
		return monitoredHostList;
	}

	/**
	 * @return the resultTableRefreshTimer
	 */
	public Timer getResultTableRefreshTimer() {
		return resultTableRefreshTimer;
	}

	/**
	 * @return the monitorResultTableModel
	 */
	public MonitorResultTableModel getMonitorResultTableModel() {
		return monitorResultTableModel;
	}

}
