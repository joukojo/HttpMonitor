package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MonitorResultSummarizerTest {

	@Test
	public void testMonitorResultSummarizer() {
		final MonitorResultSummarizer summarizer = new MonitorResultSummarizer();
		assertNotNull("resultsummaries is null", summarizer.resultSummaries);
		assertTrue("resultsummaries is not empty", summarizer.resultSummaries.isEmpty());
	}

	@Test
	public void testAddResult() {
		final MonitorResultSummarizer summarizer = new MonitorResultSummarizer();

		final MonitorResult result = createMockResult();

		summarizer.addResult(result);

		assertFalse("summaries are empty", summarizer.resultSummaries.isEmpty());

		summarizer.addResult(result);
		assertFalse("summaries are empty", summarizer.resultSummaries.isEmpty());
		assertTrue("summaries size is wrong", summarizer.resultSummaries.size() == 1);

		result.setUrl("http://localhost/junit22.html");
		summarizer.addResult(result);
		assertFalse("summaries are empty", summarizer.resultSummaries.isEmpty());
		assertTrue("summaries size is wrong", summarizer.resultSummaries.size() == 2);

	}

	protected MonitorResult createMockResult() {
		final MonitorResult result = new MonitorResult();
		result.setExecuteTime(1234l);
		result.setNumberOfBytes(1234);
		result.setStatusCode(200);
		result.setTime(1234l);
		result.setUrl("http://localhost/junit.html");
		return result;
	}

	@Test
	public void testClearResults() {
		final MonitorResultSummarizer summarizer = new MonitorResultSummarizer();

		for (int i = 0; i < 5; i++) {
			final MonitorResult result = createMockResult();
			summarizer.addResult(result);
		}

		summarizer.clearResults();
		assertNotNull("resultsummaries is null", summarizer.resultSummaries);
		assertTrue("resultsummaries is not empty", summarizer.resultSummaries.isEmpty());
	}

	@Test
	public void testGetSummaries() {
		final MonitorResultSummarizer summarizer = new MonitorResultSummarizer();

		assertTrue("result summaries is not empty", summarizer.getSummaries().isEmpty());

	}

}
