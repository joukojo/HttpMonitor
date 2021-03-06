package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class SaveMonitorTargetActionListenerImpl implements ActionListener {

	private final MonitorTargetForm monitorTargetForm;

	public SaveMonitorTargetActionListenerImpl(final MonitorTargetForm monitorTargetForm) {

		this.monitorTargetForm = monitorTargetForm;

	}

	@Override
	public void actionPerformed(final ActionEvent e) {

		final MonitorTarget target = new MonitorTarget();
		target.setHost(monitorTargetForm.getServerTextField().getText());
		target.setMethod(monitorTargetForm.getMethodList().getSelectedItem().toString());
		target.setPath(monitorTargetForm.getPathTextField().getText());
		target.setPort(Integer.valueOf(monitorTargetForm.getPortTextField().getText()));
		target.setProtocol(monitorTargetForm.getProtocolList().getSelectedItem().toString());
		target.setSleepPeriod(Long.valueOf(monitorTargetForm.getDelaySlider().getValue()));
		monitorTargetForm.clear();
		final HttpMonitorAppForm appFormInstance = HttpMonitorAppFormFactory.getAppFormInstance();

		appFormInstance.getMonitorTargets().add(target);

		appFormInstance.refreshHostList();
		appFormInstance.getMonitoredHostList().validate();
		appFormInstance.getMonitoredHostList().repaint();
		HttpMonitorAppFrameFactory.getAppFrameInstance().repaint();
		// Hide the frame
		final ModifyTargetFrame modifyTargetFrame = ModifyTargetFrameFactory.getFrameInstance();
		modifyTargetFrame.setVisible(false);
		modifyTargetFrame.setEnabled(false);

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
