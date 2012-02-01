package com.yogocodes.httpmonitor.gui.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import com.yogocodes.httpmonitor.core.MonitorTarget;

public class TargetHostListModel extends AbstractListModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private volatile List<MonitorTarget> monitorTargets;

	public TargetHostListModel() {
		monitorTargets = new ArrayList<MonitorTarget>();
	}

	public void addTarget(final MonitorTarget monitorTarget) {
		monitorTargets.add(monitorTarget);
	}

	@Override
	public int getSize() {
		return monitorTargets.size();
	}

	@Override
	public Object getElementAt(final int index) {

		return monitorTargets.get(index);
	}

}
