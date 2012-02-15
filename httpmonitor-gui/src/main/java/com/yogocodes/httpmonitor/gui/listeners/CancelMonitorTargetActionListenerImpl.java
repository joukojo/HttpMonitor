package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.form.MonitorTargetFormFactory;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class CancelMonitorTargetActionListenerImpl implements ActionListener {

	/**
	 * To access the form values
	 */
	private final MonitorTargetForm monitorTargetForm;

	/**
	 * Default constructor
	 * 
	 * @see MonitorTargetFormFactory
	 */
	public CancelMonitorTargetActionListenerImpl() {
		this.monitorTargetForm = MonitorTargetFormFactory.getMonitorTargetFormInstance();
	}

	public CancelMonitorTargetActionListenerImpl(final MonitorTargetForm monitorTargetForm) {
		this.monitorTargetForm = monitorTargetForm;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final ModifyTargetFrame modifyTargetFrame = ModifyTargetFrameFactory.getFrameInstance();

		monitorTargetForm.clear();
		modifyTargetFrame.setVisible(false);
		modifyTargetFrame.setEnabled(false);

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
