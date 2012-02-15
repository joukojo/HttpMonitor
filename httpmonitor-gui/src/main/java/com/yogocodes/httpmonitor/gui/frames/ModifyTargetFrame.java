package com.yogocodes.httpmonitor.gui.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetFormFactory;

public class ModifyTargetFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModifyTargetFrame() {
		super("Add target");

		setSize(200, 200);
		final MonitorTargetForm monitorTargetForm = MonitorTargetFormFactory.getMonitorTargetFormInstance();

		final JPanel formPanel = new JPanel(new GridLayout(6, 2));
		formPanel.add(monitorTargetForm.getProtocolLabel());
		formPanel.add(monitorTargetForm.getProtocolList());
		formPanel.add(monitorTargetForm.getMethodLabel());
		formPanel.add(monitorTargetForm.getMethodList());
		formPanel.add(monitorTargetForm.getServerLabel());
		formPanel.add(monitorTargetForm.getServerTextField());
		formPanel.add(monitorTargetForm.getPortLabel());
		formPanel.add(monitorTargetForm.getPortTextField());
		formPanel.add(monitorTargetForm.getPathLabel());
		formPanel.add(monitorTargetForm.getPathTextField());
		formPanel.add(new JLabel("Delay"));
		formPanel.add(monitorTargetForm.getDelaySlider());

		final JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(monitorTargetForm.getSaveButton());
		buttonPanel.add(monitorTargetForm.getCancelButton());

		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	}
}
