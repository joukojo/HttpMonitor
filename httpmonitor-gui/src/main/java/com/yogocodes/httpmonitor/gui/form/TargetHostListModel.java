package com.yogocodes.httpmonitor.gui.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.yogocodes.httpmonitor.core.MonitorTarget;

/**
 * List model for viewing target hosts.
 * 
 * @author joukojo
 * 
 */
public class TargetHostListModel extends AbstractListModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * monitor targets
	 */
	protected final List<MonitorTarget> monitorTargets;

	/**
	 * Default constructor
	 */
	public TargetHostListModel() {
		monitorTargets = new ArrayList<MonitorTarget>();
	}

	/**
	 * Add new monitor target
	 * 
	 * @param monitorTarget
	 *            monitor target to list
	 */
	public void addTarget(final MonitorTarget monitorTarget) {
		monitorTargets.add(monitorTarget);
	}

	/**
	 * Gets the size of the monitored targets.
	 * 
	 * @return number of targets.
	 * @see AbstractListModel#getSize()
	 */
	@Override
	public int getSize() {
		return monitorTargets.size();
	}

	/**
	 * Gets the target for specific index
	 * 
	 * @return MonitorTarget instance
	 * @see AbstractListModel#getElementAt(int)
	 */
	@Override
	public Object getElementAt(final int index) {

		return monitorTargets.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("monitorTargets", monitorTargets);
		return builder.toString();
	}

}
