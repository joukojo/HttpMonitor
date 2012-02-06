package com.yogocodes.httpmonitor.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MonitorLogWriter {

	public void writeCSVLog(final MonitorResult result) throws IOException {

		final SystemPropertyContainer propertyContainer = SystemPropertyContainerFactory.getContainerInstance();
		final File file = new File(propertyContainer.getLogFileName());
		writeCSVLog(file, result);
	}

	protected void writeCSVLog(final File file, final MonitorResult result) throws IOException {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(file, true);
			writeCSVLog(result, fileWriter);
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}

	protected void writeCSVLog(final MonitorResult result, final FileWriter fileWriter) throws IOException {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(fileWriter);
			final String line = result.toCSVLine();
			synchronized (MonitorLogWriter.class) {
				bufferedWriter.write(line);
				bufferedWriter.flush();
			}

		} finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}

	}
}
