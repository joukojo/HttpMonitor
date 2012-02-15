package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.apache.commons.lang.builder.ToStringBuilder;

public class EnableDisableButtonActionListenerImpl implements ActionListener {

	private final JButton button1;
	private final JButton button2;

	/**
	 * 
	 */
	public EnableDisableButtonActionListenerImpl() {
		button1 = null;
		button2 = null;
	}

	public EnableDisableButtonActionListenerImpl(final JButton button1, final JButton button2) {
		this.button1 = button1;
		this.button2 = button2;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {

		button1.setEnabled(!button1.isEnabled());
		button2.setEnabled(!button2.isEnabled());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("button1", button1);
		builder.append("button2", button2);
		return builder.toString();
	}

}
