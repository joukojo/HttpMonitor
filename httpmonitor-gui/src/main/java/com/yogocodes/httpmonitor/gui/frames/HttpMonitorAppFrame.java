/**
 * 
 */
package com.yogocodes.httpmonitor.gui.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.listeners.StartMonitoringActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.StopMonitoringActionListenerImpl;

/**
 * @author joukojo
 * 
 */
public class HttpMonitorAppFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected HttpMonitorAppFrame() {
		super("HttpMonitorApplication");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		final HttpMonitorAppForm appForm = HttpMonitorAppFormFactory.getAppFormInstance();

		final JMenuBar menuBar = new JMenuBar();
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem newFileItem = new JMenuItem("New");
		final JMenuItem openFileItem = new JMenuItem("Open");
		final JMenuItem saveConfigFileItem = new JMenuItem("Save config");
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
		monitorStartItem.addActionListener(new StartMonitoringActionListenerImpl());
		final JMenuItem monitorEndItem = new JMenuItem("Stop");
		monitorEndItem.addActionListener(new StopMonitoringActionListenerImpl());
		monitorMenu.add(monitorStartItem);
		monitorMenu.add(monitorEndItem);
		final JMenu aboutMenu = new JMenu("About");

		menuBar.add(fileMenu);
		menuBar.add(monitorMenu);
		menuBar.add(aboutMenu);

		setJMenuBar(menuBar);

		final JPanel configurationPanel = new JPanel(new GridLayout(1, 2));
		final JPanel configurationButtonPanel = new JPanel(new GridLayout(3, 1));
		configurationButtonPanel.add(appForm.getAddHostButton());
		configurationButtonPanel.add(appForm.getEditHostButton());
		configurationButtonPanel.add(appForm.getRemoveHostButton());
		configurationPanel.add(appForm.getMonitoredHostList());
		configurationPanel.add(configurationButtonPanel);
		getContentPane().add(configurationPanel, BorderLayout.NORTH);

		final JScrollPane resultPane = new JScrollPane(appForm.getMonitorResultTable());

		final JPanel executionButtonPanel = new JPanel(new GridLayout(1, 3));
		executionButtonPanel.add(appForm.getStartMonitorButton());
		executionButtonPanel.add(appForm.getClearResultButton());
		executionButtonPanel.add(appForm.getStopMonitorButton());
		getContentPane().add(resultPane, BorderLayout.CENTER);
		getContentPane().add(executionButtonPanel, BorderLayout.SOUTH);

		setVisible(true);
		setEnabled(true);
	}
}
