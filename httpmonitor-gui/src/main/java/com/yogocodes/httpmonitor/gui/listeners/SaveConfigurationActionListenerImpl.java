/**
 * 
 */
package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.core.MonitorTarget;
import com.yogocodes.httpmonitor.core.MonitorTargetConfig;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;

/**
 * @author joukojo
 * 
 */
public class SaveConfigurationActionListenerImpl implements ActionListener {

	private final Logger logger = LoggerFactory.getLogger(SaveConfigurationActionListenerImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {

		final JFileChooser jc = new JFileChooser();

		final int event = jc.showSaveDialog(null);

		logger.debug("event status {}", event);

		if (event == JFileChooser.APPROVE_OPTION) {
			try {
				final JAXBContext jaxbContext = JAXBContext.newInstance(MonitorTargetConfig.class);

				final Marshaller marshaller = jaxbContext.createMarshaller();

				marshaller.setProperty("jaxb.formatted.output", true);

				final File targetFile = jc.getSelectedFile();
				final HttpMonitorAppForm appFormInstance = HttpMonitorAppFormFactory.getAppFormInstance();
				final List<MonitorTarget> monitorTargets = appFormInstance.getMonitorTargets();

				final MonitorTargetConfig config = new MonitorTargetConfig();
				config.setTargets(monitorTargets);
				marshaller.marshal(config, targetFile);
			} catch (final PropertyException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (final JAXBException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}

	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
