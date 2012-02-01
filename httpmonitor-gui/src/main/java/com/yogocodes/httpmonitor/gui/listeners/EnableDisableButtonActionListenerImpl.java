package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EnableDisableButtonActionListenerImpl implements ActionListener {

	private final JButton button1; 
	private final JButton button2; 
	public EnableDisableButtonActionListenerImpl(JButton button1, JButton button2) {
		this.button1 = button1;
		this.button2 = button2; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		button1.setEnabled(!button1.isEnabled());
		button2.setEnabled(!button2.isEnabled());
		
	}

}
