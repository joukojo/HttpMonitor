package com.yogocodes.httpmonitor.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates a summary from given results. To create a instance use the factory
 * class.
 * 
 * @author joukojo
 * @see MonitorResultSummarizerFactory
 * 
 */
public class MonitorResultSummarizer {

	protected final Map<String, MonitorResultSummary> resultSummaries;

	/**
	 * Default constructor
	 * 
	 */
	protected MonitorResultSummarizer() {
		resultSummaries = new HashMap<String, MonitorResultSummary>();
	}

	/**
	 * Add monitor result and calculates the summary
	 * 
	 * @param result
	 *            from monitorworker
	 */
	public void addResult(final MonitorResult result) {
		final String url = result.getUrl();
		MonitorResultSummary summary;
		if (resultSummaries.containsKey(url)) {
			summary = resultSummaries.get(url);
		} else {
			summary = new MonitorResultSummary();
			summary.setHost(url);
		}
		final Long time = result.getTime();
		summary.setTime(time);

		final long minTime = summary.getMinTime();

		if (time < minTime) {
			summary.setMinTime(time);
		}
		final long maxTime = summary.getMaxTime();
		if (time > maxTime) {
			summary.setMaxTime(time);
		}
		summary.setTotalTime(summary.getTotalTime() + time);
		summary.setNumberOfRequests(summary.getNumberOfRequests() + 1);
		resultSummaries.put(url, summary);
	}

	/**
	 * Clears the summaries
	 */
	public void clearResults() {
		resultSummaries.clear();
	}

	/**
	 * Gets the summaries.
	 * 
	 * @return list of summaries
	 * @see MonitorResultSummary
	 */
	public List<MonitorResultSummary> getSummaries() {

		return new ArrayList<MonitorResultSummary>(resultSummaries.values());
	}

}
