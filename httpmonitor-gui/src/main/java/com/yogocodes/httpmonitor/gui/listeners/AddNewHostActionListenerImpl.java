package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrame;
import com.yogocodes.httpmonitor.gui.frames.ModifyTargetFrameFactory;

public class AddNewHostActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ModifyTargetFrame frameInstance = ModifyTargetFrameFactory.getFrameInstance();
		frameInstance.setEnabled(true);
		frameInstance.setVisible(true);
		
	}

}
