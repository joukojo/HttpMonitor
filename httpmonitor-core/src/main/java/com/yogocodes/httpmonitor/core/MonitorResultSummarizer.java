package com.yogocodes.httpmonitor.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonitorResultSummarizer {

	private final Map<String, MonitorResultSummary> resultSummaries;

	public MonitorResultSummarizer() {
		resultSummaries = new HashMap<String, MonitorResultSummary>();
	}

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

	public void clearResults() {
		resultSummaries.clear();
	}

	public List<MonitorResultSummary> getSummaries() {

		return new ArrayList<MonitorResultSummary>(resultSummaries.values());
	}

}
