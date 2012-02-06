package com.yogocodes.httpmonitor.gui.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;

public class RemoveHostActionListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		final HttpMonitorAppForm appFormInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		final int selectedIndex = appFormInstance.getMonitoredHostList().getSelectedIndex();

		if (selectedIndex != -1) {
			appFormInstance.getMonitorTargets().remove(selectedIndex);

			appFormInstance.refreshHostList();
			appFormInstance.getMonitoredHostList().validate();
			appFormInstance.getMonitoredHostList().repaint();
			HttpMonitorAppFrameFactory.getAppFrameInstance().repaint();
		}
	}

}
