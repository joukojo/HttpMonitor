/**
 * 
 */
package com.yogocodes.httpmonitor.gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrame;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;

/**
 *  HttpMonitor application which is used to start the gui interface.
 * 
 * @author joukojo
 *
 */
public class HttpMonitorApp {

	/**
	 * Main method
	 * @param args cli arguments
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					
					HttpMonitorAppFrameFactory.getAppFrameInstance();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});

	}

}
