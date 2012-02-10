/**
 * 
 */
package com.yogocodes.httpmonitor.gui.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;

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
		setJMenuBar(appForm.getMenuBar());
		setLocationRelativeTo(null);
		setVisible(true);
		setEnabled(true);
	}
}
