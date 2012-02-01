package com.yogocodes.httpmonitor.gui.form;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class MonitorTargetForm {

	private final JLabel protocolLabel;
	private final JLabel methodLabel;
	private final JLabel serverLabel;
	private final JLabel portLabel;
	private final JLabel pathLabel; 
	
	private final JList protocolList;
	private final JList methodList;
	private final JTextField serverTextField;
	private final JTextField portTextField;
	private final JTextField pathTextField; 
	
	private final JButton saveButton; 
	private final JButton cancelButton; 
	
	protected MonitorTargetForm() {
		protocolLabel = new JLabel("protocol:");
		methodLabel = new JLabel("method:");
		serverLabel = new JLabel("server:");
		portLabel = new JLabel("port:");
		pathLabel = new JLabel("path:");
		
		Object protocols[] = {"http", "https"};
		Object methods[] = {"GET", "DELETE", "POST", "HEAD"}; 
		protocolList = new JList(protocols);
		methodList = new JList(methods);
		serverTextField = new JTextField();
		portTextField = new JTextField();
		pathTextField = new JTextField(); 
		
		saveButton = new JButton("save");
		cancelButton = new JButton("cancel"); 
	}

	public JLabel getProtocolLabel() {
		return protocolLabel;
	}

	public JLabel getMethodLabel() {
		return methodLabel;
	}

	public JLabel getServerLabel() {
		return serverLabel;
	}

	public JLabel getPortLabel() {
		return portLabel;
	}

	public JLabel getPathLabel() {
		return pathLabel;
	}

	public JList getProtocolList() {
		return protocolList;
	}

	public JList getMethodList() {
		return methodList;
	}

	public JTextField getServerTextField() {
		return serverTextField;
	}

	public JTextField getPortTextField() {
		return portTextField;
	}

	public JTextField getPathTextField() {
		return pathTextField;
	}

	/**
	 * @return the cancelButton
	 */
	public JButton getCancelButton() {
		return cancelButton;
	}

	/**
	 * @return the saveButton
	 */
	public JButton getSaveButton() {
		return saveButton;
	}
	
	
}
