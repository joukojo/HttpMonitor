package com.yogocodes.httpmonitor.gui.frames;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ModifyTargetFrameFactory {

	private static ModifyTargetFrame frameInstance;

	public static ModifyTargetFrame getFrameInstance() {

		if (null == frameInstance) {
			frameInstance = new ModifyTargetFrame();
		}

		return frameInstance;
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this);
		return builder.toString();
	}
}
