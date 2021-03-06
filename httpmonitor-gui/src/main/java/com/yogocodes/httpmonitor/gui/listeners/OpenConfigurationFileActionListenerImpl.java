/**
 * 
 */
package com.yogocodes.httpmonitor.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yogocodes.httpmonitor.core.MonitorTargetConfig;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppForm;
import com.yogocodes.httpmonitor.gui.form.HttpMonitorAppFormFactory;
import com.yogocodes.httpmonitor.gui.frames.HttpMonitorAppFrameFactory;

/**
 * @author joukojo
 * 
 */
public class OpenConfigurationFileActionListenerImpl implements ActionListener {

	private final Logger LOG = LoggerFactory.getLogger(OpenConfigurationFileActionListenerImpl.class);

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {

		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// FileFilter fileFilter = new FileFilter() {
		//
		// @Override
		// public String getDescription() {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		// @Override
		// public boolean accept(File f) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		// };
		// fc.setFileFilter(fileFilter );

		final int status = fc.showOpenDialog(null);

		if (status == JFileChooser.APPROVE_OPTION) {
			try {
				final JAXBContext jaxbContext = JAXBContext.newInstance(MonitorTargetConfig.class);
				final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				final MonitorTargetConfig config = (MonitorTargetConfig) unmarshaller.unmarshal(fc.getSelectedFile());

				final HttpMonitorAppForm formInstance = HttpMonitorAppFormFactory.getAppFormInstance();
				formInstance.getMonitorTargets().clear();
				formInstance.getMonitorTargets().addAll(config.getTargets());
				formInstance.refreshHostList();
				formInstance.getMonitoredHostList().validate();
				formInstance.getMonitoredHostList().repaint();
				HttpMonitorAppFrameFactory.getAppFrameInstance().repaint();

			} catch (final JAXBException e1) {
				LOG.error("Failed to read configuration file:" + e1.getMessage(), e1);
			}
		}
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}

}
