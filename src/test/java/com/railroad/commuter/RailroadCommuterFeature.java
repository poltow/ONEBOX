package com.railroad.commuter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RailroadCommuterFeature {
	
	private RailroadCommuter railroadCommuter;
	private RailroadNetwork railroadNetwork;

	@Before
	public void setup() {
		railroadNetwork = new RailroadNetwork();
		railroadCommuter = new RailroadCommuter(railroadNetwork);
	}
	
	@Test
	public void obtain_path_distance_for_every_town_sequence() {

		railroadNetwork.addInterTownRoute("AB5");
		railroadNetwork.addInterTownRoute("BC4");
		railroadNetwork.addInterTownRoute("CD8");
		railroadNetwork.addInterTownRoute("DC8");
		railroadNetwork.addInterTownRoute("DE6");
		railroadNetwork.addInterTownRoute("AD5");
		railroadNetwork.addInterTownRoute("CE2");
		railroadNetwork.addInterTownRoute("EB3");
		railroadNetwork.addInterTownRoute("AE7");

		assertEquals("9", railroadCommuter.calculatePathDistanceFor("A-B-C"));
		assertEquals("5", railroadCommuter.calculatePathDistanceFor("A-D"));
		assertEquals("13", railroadCommuter.calculatePathDistanceFor("A-D-C"));
		assertEquals("22", railroadCommuter.calculatePathDistanceFor("A-E-B-C-D"));
		assertEquals("NO SUCH ROUTE", railroadCommuter.calculatePathDistanceFor("A-E-D"));
	}
}
