/**
 * 
 */
package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * @author joukojo
 * 
 */
public class EnableDisableMenuItemListener implements ActionListener {

	private final JMenuItem monitorStartItem;
	private final JMenuItem monitorEndItem;

	/**
	 * @param monitorStartItem
	 * @param monitorEndItem
	 */
	public EnableDisableMenuItemListener(final JMenuItem monitorStartItem, final JMenuItem monitorEndItem) {
		this.monitorEndItem = monitorEndItem;
		this.monitorStartItem = monitorStartItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		this.monitorEndItem.setEnabled(!monitorEndItem.isEnabled());
		this.monitorStartItem.setEnabled(!monitorStartItem.isEnabled());
	}

}
