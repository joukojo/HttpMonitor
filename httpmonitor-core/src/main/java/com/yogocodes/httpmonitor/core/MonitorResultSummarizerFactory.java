package com.yogocodes.httpmonitor.core;

public class MonitorResultSummarizerFactory {

	private static MonitorResultSummarizer summarizerInstance;

	public static MonitorResultSummarizer getInstance() {
		if (summarizerInstance == null) {
			summarizerInstance = new MonitorResultSummarizer();
		}
		return summarizerInstance;
	}

}
