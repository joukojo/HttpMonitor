package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AboutMenuActionListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Warranty void. Use at your risk", "HttpMonitor", JOptionPane.INFORMATION_MESSAGE);
	}

}
