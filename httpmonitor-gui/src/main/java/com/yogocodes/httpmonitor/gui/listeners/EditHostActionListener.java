package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetFormFactory;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrame;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class EditHostActionListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		final HttpMonitorAppForm formInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		final MonitorTargetForm targetFormInstance = MonitorTargetFormFactory.getMonitorTargetFormInstance();
		final HttpMonitorAppFrame appFrame = HttpMonitorAppFrameFactory.getAppFrameInstance();

		final int selectedIndex = formInstance.getMonitoredHostList().getSelectedIndex();

		if (selectedIndex != -1) {
			final List<MonitorTarget> monitorTargets = formInstance.getMonitorTargets();
			if (selectedIndex < monitorTargets.size()) {
				final MonitorTarget target = monitorTargets.get(selectedIndex);
				targetFormInstance.setValues(target);

				final ModifyTargetFrame frameInstance = ModifyTargetFrameFactory.getFrameInstance();

				frameInstance.setLocationRelativeTo(appFrame);
				frameInstance.setEnabled(true);
				frameInstance.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select target to edit", "Warning", JOptionPane.WARNING_MESSAGE);
		}

	}
}
