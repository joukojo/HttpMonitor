package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.core.HttpMonitorEngine;
import com.yogocodes.httpmonitor.core.HttpMonitorEngineFactory;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;

public class StopMonitoringActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		final HttpMonitorAppForm appForm = HttpMonitorAppFormFactory
				.getAppFormInstance();
		appForm.getResultTableRefreshTimer().stop();

		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory
				.getEngineInstance();
		engineInstance.stop();
	}

}
