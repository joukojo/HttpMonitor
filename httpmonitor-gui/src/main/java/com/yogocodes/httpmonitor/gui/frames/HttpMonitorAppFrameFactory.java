package com.yogocodes.httpmonitor.gui.frames;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpMonitorAppFrameFactory {

	private static final Logger LOG = LoggerFactory.getLogger(HttpMonitorAppFrameFactory.class);
	private static HttpMonitorAppFrame appFrameInstance;

	/**
	 * @return the appFrameInstance
	 */
	public static HttpMonitorAppFrame getAppFrameInstance() {

		if (null == appFrameInstance) {
			synchronized (HttpMonitorAppFrameFactory.class) {
				if (null == appFrameInstance) {
					LOG.debug("creating new application frame instance");
					appFrameInstance = new HttpMonitorAppFrame();
				}
			}
		}

		return appFrameInstance;
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
