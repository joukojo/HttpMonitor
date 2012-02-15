package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.lang.builder.ToStringBuilder;

public class AboutMenuActionListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Warranty void. Use at your risk", "HttpMonitor", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
