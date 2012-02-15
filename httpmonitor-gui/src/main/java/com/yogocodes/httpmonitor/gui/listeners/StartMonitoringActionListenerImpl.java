package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.yogocodes.httpmonitor.core.HttpMonitorEngine;
import com.yogocodes.httpmonitor.core.HttpMonitorEngineFactory;
import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;

public class StartMonitoringActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent event) {

		final HttpMonitorAppForm appForm = HttpMonitorAppFormFactory.getAppFormInstance();
		final HttpMonitorEngine engineInstance = HttpMonitorEngineFactory.getEngineInstance();
		final List<MonitorTarget> targets = appForm.getMonitorTargets();
		engineInstance.getTargets().clear();
		engineInstance.getTargets().addAll(targets);
		engineInstance.start();
		appForm.getResultTableRefreshTimer().start();
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
