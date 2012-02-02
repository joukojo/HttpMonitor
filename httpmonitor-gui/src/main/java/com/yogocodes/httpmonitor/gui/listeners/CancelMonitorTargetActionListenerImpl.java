package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.gui.form.MonitorTargetForm;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class CancelMonitorTargetActionListenerImpl implements ActionListener {

	private final MonitorTargetForm monitorTargetForm;

	public CancelMonitorTargetActionListenerImpl(
			final MonitorTargetForm monitorTargetForm) {
		this.monitorTargetForm = monitorTargetForm;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final ModifyTargetFrame modifyTargetFrame = ModifyTargetFrameFactory
				.getFrameInstance();

		// FIXME if we're cancelling the frame, we could be nice and clean
		// the form object

		modifyTargetFrame.setVisible(false);
		modifyTargetFrame.setEnabled(false);

	}

}
