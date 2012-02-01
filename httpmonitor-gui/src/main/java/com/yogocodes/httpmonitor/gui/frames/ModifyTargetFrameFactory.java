package com.yogocodes.httpmonitor.gui.frames;

public class ModifyTargetFrameFactory {

	
	private static ModifyTargetFrame frameInstance;

	public static ModifyTargetFrame getFrameInstance() {
		
		if(frameInstance == null ) {
			frameInstance = new ModifyTargetFrame();
		}
		
		
		return frameInstance;
	}
	
	
}
