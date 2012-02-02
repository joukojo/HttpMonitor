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

		summary.setTime(result.getTime());

		resultSummaries.put(url, summary);
	}

	public void clearResults() {
		resultSummaries.clear();
	}

	public List<MonitorResultSummary> getSummaries() {

		return new ArrayList(resultSummaries.values());
	}

}
