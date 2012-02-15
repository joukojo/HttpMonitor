package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrame;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class AddNewHostActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {

		final ModifyTargetFrame frameInstance = ModifyTargetFrameFactory.getFrameInstance();
		final HttpMonitorAppFrame appFrame = HttpMonitorAppFrameFactory.getAppFrameInstance();
		frameInstance.setLocationRelativeTo(appFrame);
		frameInstance.setEnabled(true);
		frameInstance.setVisible(true);

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
