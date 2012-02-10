package com.yogocodes.httpmonitor.core;

/**
 * Factory class for MonitorResultSummarizer.
 * 
 * @author joukojo
 * @see MonitorResultSummarizer
 * 
 */
public class MonitorResultSummarizerFactory {

	private static MonitorResultSummarizer summarizerInstance;

	/**
	 * Gets the shared summarizer instance
	 * 
	 * @return shared instance.
	 */
	public static MonitorResultSummarizer getInstance() {
		if (summarizerInstance == null) {

			synchronized (MonitorResultSummarizerFactory.class) {
				if (summarizerInstance == null) {
					summarizerInstance = new MonitorResultSummarizer();
				}
			}

		}
		return summarizerInstance;
	}

}
