/**
 * 
 */
package com.yogocodes.httpmonitor.gui.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.listeners.AboutMenuActionListener;
import com.yogocodes.httpmonitor.gui.listeners.AddNewHostActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.ClearMonitorResultsActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.EditHostActionListener;
import com.yogocodes.httpmonitor.gui.listeners.EnableDisableButtonActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.EnableDisableMenuItemListener;
import com.yogocodes.httpmonitor.gui.listeners.OpenConfigurationFileActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.RemoveHostActionListener;
import com.yogocodes.httpmonitor.gui.listeners.ResultTableRefreshActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.SaveConfigurationActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.StartMonitoringActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.StopMonitoringActionListenerImpl;

/**
 * Application main form object which is used as a value container. For creating
 * instace use the factory class.
 * 
 * @author joukojo
 * @see HttpMonitorAppFormFactory#getAppFormInstance()
 * 
 */
public class HttpMonitorAppForm implements Serializable {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;

	private final JButton addHostButton;
	private final JButton removeHostButton;
	private final JButton clearResultButton;
	private final JButton editHostButton;
	private final JTable monitorResultTable;
	private final MonitorResultTableModel monitorResultTableModel;
	private final JList monitoredHostList;
	private final JButton startMonitorButton;
	private final JButton stopMonitorButton;
	private final Timer resultTableRefreshTimer;
	private final List<MonitorTarget> monitorTargets;

	private final DefaultListModel targetHostListModel;

	private final JMenuBar menuBar;

	/**
	 * Default constructor which initializes all the components.
	 */
	protected HttpMonitorAppForm() {
		addHostButton = new JButton("Add");
		addHostButton.addActionListener(new AddNewHostActionListenerImpl());
		removeHostButton = new JButton("Remove");
		removeHostButton.addActionListener(new RemoveHostActionListener());
		editHostButton = new JButton("Edit");
		editHostButton.addActionListener(new EditHostActionListener());
		monitorResultTableModel = new MonitorResultTableModel();
		monitorResultTable = new JTable();
		monitorResultTable.setModel(monitorResultTableModel);
		monitorResultTable.setShowGrid(true);
		monitorResultTable.setGridColor(monitorResultTable.getTableHeader().getBackground());
		startMonitorButton = new JButton("Start");
		stopMonitorButton = new JButton("Stop");
		stopMonitorButton.setEnabled(false);
		clearResultButton = new JButton("Clear");
		monitorTargets = new ArrayList<MonitorTarget>();
		targetHostListModel = new DefaultListModel();
		final MonitorTarget target = new MonitorTarget();
		target.setHost("localhost");
		target.setMethod("GET");
		target.setPath("robots.txt");
		target.setPort(80);
		target.setProtocol("http");
		getMonitorTargets().add(target);
		refreshHostList();
		monitoredHostList = new JList(this.getTargetHostListModel());

		final EnableDisableButtonActionListenerImpl buttonListener = new EnableDisableButtonActionListenerImpl(startMonitorButton, stopMonitorButton);
		startMonitorButton.addActionListener(buttonListener);
		startMonitorButton.addActionListener(new StartMonitoringActionListenerImpl());
		stopMonitorButton.addActionListener(buttonListener);
		stopMonitorButton.addActionListener(new StopMonitoringActionListenerImpl());
		getClearResultButton().addActionListener(new ClearMonitorResultsActionListenerImpl());
		resultTableRefreshTimer = new Timer(500, new ResultTableRefreshActionListenerImpl());

		menuBar = new JMenuBar();
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem newFileItem = new JMenuItem("New");
		final JMenuItem openFileItem = new JMenuItem("Open");
		openFileItem.addActionListener(new OpenConfigurationFileActionListenerImpl());
		final JMenuItem saveConfigFileItem = new JMenuItem("Save config");
		saveConfigFileItem.addActionListener(new SaveConfigurationActionListenerImpl());
		final JMenuItem saveResultFileItem = new JMenuItem("Save results");
		final JMenuItem exitFileItem = new JMenuItem("Exit");
		exitFileItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);

			}
		});
		final JSeparator separator = new JSeparator();
		fileMenu.add(newFileItem);
		fileMenu.add(openFileItem);

		fileMenu.add(saveConfigFileItem);
		fileMenu.add(saveResultFileItem);
		fileMenu.add(separator);
		fileMenu.add(exitFileItem);

		final JMenu monitorMenu = new JMenu("Monitor");
		final JMenuItem monitorStartItem = new JMenuItem("Start");
		final JMenuItem monitorEndItem = new JMenuItem("Stop");
		monitorStartItem.setEnabled(true);
		monitorStartItem.addActionListener(new StartMonitoringActionListenerImpl());
		monitorStartItem.addActionListener(buttonListener);

		final EnableDisableMenuItemListener menuItemListener = new EnableDisableMenuItemListener(monitorStartItem, monitorEndItem);
		monitorStartItem.addActionListener(menuItemListener);
		monitorEndItem.addActionListener(new StopMonitoringActionListenerImpl());
		monitorEndItem.setEnabled(false);
		this.startMonitorButton.addActionListener(menuItemListener);
		this.stopMonitorButton.addActionListener(menuItemListener);
		monitorEndItem.addActionListener(buttonListener);
		monitorEndItem.addActionListener(menuItemListener);
		monitorMenu.add(monitorStartItem);
		monitorMenu.add(monitorEndItem);
		final JMenu helpMenu = new JMenu("Help");

		final JMenuItem aboutMenutItem = new JMenuItem("About");
		aboutMenutItem.addActionListener(new AboutMenuActionListener());
		final JMenu viewGraphMenu = new JMenu("Graph");
		final JMenuItem viewItem = new JMenuItem("View");
		viewItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				final XYSeries series = new XYSeries("Response times");
				series.add(20.0, 20.0);
				series.add(40.0, 25.0);
				series.add(55.0, 50.0);
				series.add(70.0, 65.0);

				final XYSeries series2 = new XYSeries("Response times2");
				series2.add(20.0, 30.0);
				series2.add(40.0, 35.0);
				series2.add(55.0, 70.0);
				series2.add(70.0, 85.0);

				final XYSeriesCollection xyDataset = new XYSeriesCollection(series);
				xyDataset.addSeries(series2);

				final JFreeChart chart = ChartFactory.createXYLineChart("Response times", "Time", "Response time(ms)", xyDataset, PlotOrientation.VERTICAL, true, true, false);

				final ChartFrame frame1 = new ChartFrame("Performance charts", chart);

				frame1.setSize(500, 500);
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
			}
		});

		viewGraphMenu.add(viewItem);
		helpMenu.add(aboutMenutItem);
		getMenuBar().add(fileMenu);
		getMenuBar().add(monitorMenu);
		getMenuBar().add(viewGraphMenu);
		getMenuBar().add(helpMenu);

	}

	/**
	 * Refresh the host list.
	 * 
	 * @see #targetHostListModel
	 * @see #monitorTargets
	 */
	public void refreshHostList() {
		targetHostListModel.removeAllElements();
		for (final MonitorTarget target : this.monitorTargets) {
			targetHostListModel.addElement(target.toString());
		}

	}

	/**
	 * Gets the value of serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the value of addHostButton.
	 * 
	 * @return the addHostButton
	 */
	public JButton getAddHostButton() {
		return addHostButton;
	}

	/**
	 * Gets the value of removeHostButton.
	 * 
	 * @return the removeHostButton
	 */
	public JButton getRemoveHostButton() {
		return removeHostButton;
	}

	/**
	 * Gets the value of clearResultButton.
	 * 
	 * @return the clearResultButton
	 */
	public JButton getClearResultButton() {
		return clearResultButton;
	}

	/**
	 * Gets the value of editHostButton.
	 * 
	 * @return the editHostButton
	 */
	public JButton getEditHostButton() {
		return editHostButton;
	}

	/**
	 * Gets the value of monitorResultTable.
	 * 
	 * @return the monitorResultTable
	 */
	public JTable getMonitorResultTable() {
		return monitorResultTable;
	}

	/**
	 * Gets the value of monitorResultTableModel.
	 * 
	 * @return the monitorResultTableModel
	 */
	public MonitorResultTableModel getMonitorResultTableModel() {
		return monitorResultTableModel;
	}

	/**
	 * Gets the value of monitoredHostList.
	 * 
	 * @return the monitoredHostList
	 */
	public JList getMonitoredHostList() {
		return monitoredHostList;
	}

	/**
	 * Gets the value of startMonitorButton.
	 * 
	 * @return the startMonitorButton
	 */
	public JButton getStartMonitorButton() {
		return startMonitorButton;
	}

	/**
	 * Gets the value of stopMonitorButton.
	 * 
	 * @return the stopMonitorButton
	 */
	public JButton getStopMonitorButton() {
		return stopMonitorButton;
	}

	/**
	 * Gets the value of resultTableRefreshTimer.
	 * 
	 * @return the resultTableRefreshTimer
	 */
	public Timer getResultTableRefreshTimer() {
		return resultTableRefreshTimer;
	}

	/**
	 * Gets the value of monitorTargets.
	 * 
	 * @return the monitorTargets
	 */
	public List<MonitorTarget> getMonitorTargets() {
		return monitorTargets;
	}

	/**
	 * Gets the value of targetHostListModel.
	 * 
	 * @return the targetHostListModel
	 */
	public DefaultListModel getTargetHostListModel() {
		return targetHostListModel;
	}

	/**
	 * Gets the value of menuBar.
	 * 
	 * @return the menuBar
	 */
	public JMenuBar getMenuBar() {
		return menuBar;
	}

}
