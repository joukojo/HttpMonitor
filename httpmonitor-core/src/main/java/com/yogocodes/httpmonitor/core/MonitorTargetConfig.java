package com.yogocodes.httpmonitor.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "monitor-config")
@XmlAccessorType(XmlAccessType.FIELD)
public class MonitorTargetConfig {

	@XmlElementWrapper(name = "targets")
	@XmlElement(name = "target")
	private List<MonitorTarget> targets;

	/**
	 * @return the targets
	 */
	public List<MonitorTarget> getTargets() {
		return targets;
	}

	/**
	 * @param targets
	 *            the targets to set
	 */
	public void setTargets(final List<MonitorTarget> targets) {
		this.targets = targets;
	}

}
