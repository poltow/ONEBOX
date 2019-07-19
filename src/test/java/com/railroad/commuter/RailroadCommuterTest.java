package com.railroad.commuter;

import org.junit.Before;
import org.junit.Test;

public class RailroadCommuterTest {

	private RailroadCommuter railroadCommuter;
	private RailroadNetwork railroadNetwork;

	@Before
	public void setup() {
		railroadNetwork = new RailroadNetwork();
		railroadCommuter = new RailroadCommuter(railroadNetwork);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_calculatePathDistanceFor_empty_network() {
		railroadCommuter.calculatePathDistanceFor("A-B-C");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_calculatePathDistanceFor_empty_input() {
		railroadNetwork.addInterTownRoute("AB5");
		railroadCommuter.calculatePathDistanceFor("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_calculatePathDistanceFor_wrong_input_A() {
		railroadNetwork.addInterTownRoute("AB5");
		railroadCommuter.calculatePathDistanceFor("A");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_calculatePathDistanceFor_wrong_input_A_dash() {
		railroadNetwork.addInterTownRoute("AB5");
		railroadCommuter.calculatePathDistanceFor("A-");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_calculatePathDistanceFor_town_not_in_network() {
		railroadNetwork.addInterTownRoute("AB5");
		railroadCommuter.calculatePathDistanceFor("A-C");
	}
}
