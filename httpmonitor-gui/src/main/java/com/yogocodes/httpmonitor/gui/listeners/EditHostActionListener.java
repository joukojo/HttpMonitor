package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetFormFactory;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class EditHostActionListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		final HttpMonitorAppForm formInstance = HttpMonitorAppFormFactory.getAppFormInstance();
		final MonitorTargetForm targetFormInstance = MonitorTargetFormFactory.getMonitorTargetFormInstance();
		final int selectedIndex = formInstance.getMonitoredHostList().getSelectedIndex();

		if (selectedIndex != -1) {
			final List<MonitorTarget> monitorTargets = formInstance.getMonitorTargets();
			if (selectedIndex < monitorTargets.size()) {
				final MonitorTarget target = monitorTargets.get(selectedIndex);
				targetFormInstance.setValues(target);

				final ModifyTargetFrame frameInstance = ModifyTargetFrameFactory.getFrameInstance();
				frameInstance.setEnabled(true);
				frameInstance.setVisible(true);
			}
		}

	}

}
