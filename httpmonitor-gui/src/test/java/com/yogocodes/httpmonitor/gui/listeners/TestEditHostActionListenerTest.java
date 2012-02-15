/**
 * 
 */
package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author joukojo
 * 
 */
public class TestEditHostActionListenerTest {

	/**
	 * Test method for
	 * {@link com.yogocodes.httpmonitor.gui.listeners.EditHostActionListener#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */

	public void testActionPerformed() {
		final EditHostActionListener actionListener = new EditHostActionListener();
		final JButton button = new JButton("test");
		final ActionEvent event = new ActionEvent(button, 1, "junit");

		actionListener.actionPerformed(event);

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
