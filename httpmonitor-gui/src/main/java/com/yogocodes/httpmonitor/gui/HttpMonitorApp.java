/**
 * 
 */
package com.yogocodes.httpmonitor.gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;

/**
 * HttpMonitor application which is used to start the gui interface.
 * 
 * @author joukojo
 * 
 */
public class HttpMonitorApp {

	private final static Logger LOG = LoggerFactory.getLogger(HttpMonitorApp.class);

	/**
	 * Main method
	 * 
	 * @param args
	 *            cli arguments
	 */
	public static void main(final String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

					HttpMonitorAppFrameFactory.getAppFrameInstance();

				} catch (final ClassNotFoundException e) {
					LOG.error("failed to locate class:" + e.getMessage(), e);
				} catch (final InstantiationException e) {
					LOG.error("failed to instantiate class" + e.getMessage(), e);
				} catch (final IllegalAccessException e) {
					LOG.error("Illegal access exception", e);
				} catch (final UnsupportedLookAndFeelException e) {
					LOG.error("unsupported look and feel", e);
				}

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "";
	}

}
