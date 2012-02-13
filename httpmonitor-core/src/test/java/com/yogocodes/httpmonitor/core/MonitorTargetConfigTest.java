package com.yogocodes.httpmonitor.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

public class MonitorTargetConfigTest {

	@Test
	public void testMarshalling() throws JAXBException {
		final MonitorTargetConfig config = new MonitorTargetConfig();
		final List<MonitorTarget> targets = new ArrayList<MonitorTarget>();
		for (int i = 0; i < 15; i++) {
			final MonitorTarget target = new MonitorTarget();
			target.setHost("localhost");
			target.setMethod("GET");
			target.setPath("/junit");
			target.setPort(800);
			targets.add(target);
		}
		config.setTargets(targets);
		final JAXBContext jaxbContext = JAXBContext.newInstance(MonitorTargetConfig.class);

		final Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);
		marshaller.marshal(config, System.out);
	}

}
