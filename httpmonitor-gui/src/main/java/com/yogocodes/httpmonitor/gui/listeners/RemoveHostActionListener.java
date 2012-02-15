package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;

public class RemoveHostActionListener implements ActionListener {

	private final static Logger LOG = LoggerFactory.getLogger(RemoveHostActionListener.class);

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
		} else {
			LOG.debug("tried to remove non-selected item {}", selectedIndex);
		}
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
