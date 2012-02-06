package com.yogocodes.httpmonitor.core;

public class SystemPropertyContainerFactory {

	private static SystemPropertyContainer containerInstance;

	public static SystemPropertyContainer getContainerInstance() {
		if (containerInstance == null) {
			synchronized (SystemPropertyContainerFactory.class) {
				if (containerInstance == null) {
					containerInstance = new SystemPropertyContainer();
				}
			}
		}

		return containerInstance;
	}

}
