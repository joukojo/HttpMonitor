package com.yogocodes.httpmonitor.gui.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.gui.listeners.CancelMonitorTargetActionListenerImpl;
import com.yogocodes.httpmonitor.gui.listeners.SaveMonitorTargetActionListenerImpl;

public class MonitorTargetForm {

	private final JLabel protocolLabel;
	private final JLabel methodLabel;
	private final JLabel serverLabel;
	private final JLabel portLabel;
	private final JLabel pathLabel;

	private final JComboBox protocolList;
	private final JComboBox methodList;
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

		final Object protocols[] = { "http", "https" };
		final Object methods[] = { "GET", "DELETE", "POST", "HEAD" };
		protocolList = new JComboBox(protocols);
		methodList = new JComboBox(methods);
		serverTextField = new JTextField();
		portTextField = new JTextField();
		pathTextField = new JTextField();

		saveButton = new JButton("save");
		saveButton.addActionListener(new SaveMonitorTargetActionListenerImpl(this));

		cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new CancelMonitorTargetActionListenerImpl(this));
	}

	public void clear() {
		portTextField.setText("");
		serverTextField.setText("");
		pathTextField.setText("");
		protocolList.setSelectedIndex(-1);
		methodList.setSelectedIndex(-1);
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

	public JComboBox getProtocolList() {
		return protocolList;
	}

	public JComboBox getMethodList() {
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

	public void setValues(final MonitorTarget target) {
		// FIXME handle method adn protocol
		target.getMethod();
		target.getProtocol();
		this.serverTextField.setText(target.getHost());
		this.portTextField.setText("" + target.getPort());
		this.pathTextField.setText(target.getPath());
	}

}
