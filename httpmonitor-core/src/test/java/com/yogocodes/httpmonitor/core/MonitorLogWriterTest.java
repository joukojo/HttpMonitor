package com.yogocodes.httpmonitor.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Test;

public class MonitorLogWriterTest {

	@Test
	public void testWriteCSVLogMonitorResult() throws IOException {

		final MonitorResult expected = new MonitorResult();
		final MonitorLogWriter logWriter = new MonitorLogWriter() {
			@Override
			protected void writeCSVLog(final File file, final MonitorResult result) throws IOException {
				assertNotNull("file is null", file);
				assertNotNull("result is null", result);
				assertEquals("result mismatch", expected, result);
			}
		};

		logWriter.writeCSVLog(expected);

	}

	@Test
	public void testWriteCSVLogFileMonitorResult() throws IOException {
		final MonitorResult expectedResult = new MonitorResult();
		final File expectedFile = new File("junit.txt");
		final MonitorLogWriter logWriter = new MonitorLogWriter() {
			@Override
			protected void writeCSVLog(final MonitorResult result, final FileWriter fileWriter) throws IOException {
				assertNotNull("result is null", result);
				assertNotNull("filewriter is null", fileWriter);
			}
		};

		logWriter.writeCSVLog(expectedFile, expectedResult);

	}

	@Test
	public void testWriteCSVLogFileMonitorResultToDirectory() throws IOException {
		final MonitorResult expectedResult = new MonitorResult();
		final File expectedFile = new File(".");
		final MonitorLogWriter logWriter = new MonitorLogWriter();

		try {
			logWriter.writeCSVLog(expectedFile, expectedResult);
			fail("trying to write to directory...should fail");
		} catch (final Exception e) {

		}
	}

	@AfterClass
	public static void afterClassTest() {
		final File file = new File("junit.txt");
		file.delete();
		final SystemPropertyContainer propertyContainer = SystemPropertyContainerFactory.getContainerInstance();

		final File expectedFile = new File(propertyContainer.getLogFileName());
		expectedFile.delete();

	}

	@Test
	public void testWriteCSVLogMonitorResultReal() throws IOException {

		final MonitorResult result = new MonitorResult();
		result.setExecuteTime(1234l);
		result.setNumberOfBytes(43212);
		result.setStatusCode(200);
		result.setTime(1234l);
		result.setUrl("http.//localhost/junit");
		final MonitorLogWriter logWriter = new MonitorLogWriter();
		final SystemPropertyContainer propertyContainer = SystemPropertyContainerFactory.getContainerInstance();
		propertyContainer.setExecutionStartTime(1223l);

		logWriter.writeCSVLog(result);

		final File expectedFile = new File(propertyContainer.getLogFileName());
		final Long bytes = expectedFile.length();

		assertTrue("the file is empty", bytes != 0);

	}

}
