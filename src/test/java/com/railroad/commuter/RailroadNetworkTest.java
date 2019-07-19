package com.railroad.commuter;

import java.util.Set;

import org.junit.Test;

public class RailroadNetworkTest {

	@Test(expected = NullPointerException.class)
	public void test_addInterTownRoute_null_input() {
		new RailroadNetwork().addInterTownRoute(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_empty_input() {
		new RailroadNetwork().addInterTownRoute("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_space_input() {
		new RailroadNetwork().addInterTownRoute(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_wrong_input_AZ() {
		new RailroadNetwork().addInterTownRoute("AZ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_wrong_input_AZz() {
		new RailroadNetwork().addInterTownRoute("AZz");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_wrong_input_A_Zz() {
		new RailroadNetwork().addInterTownRoute("A Zz");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_zero_distance() {
		new RailroadNetwork().addInterTownRoute("AZ0");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_add_not_inter_TownRoute() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AA1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_addInterTownRoute_wrong_input2() {
		new RailroadNetwork().addInterTownRoute("AZz");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_add_duplicated_interTownRoute() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AB1");
		railroadNetwork.addInterTownRoute("AB2");
	}

	@Test
	public void test_add_one_interTownRoute() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AB2");
		
		Set<Town> towns = railroadNetwork.getTowns();
		assert(towns.size()==2);
		
		Set<Route> routes = railroadNetwork.getRoutes();
		assert(routes.size()==1);
		
	}
	
	@Test
	public void test_add_two_iterTownRoutes_for_same_origin() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AB1");
		railroadNetwork.addInterTownRoute("AC2");
		
		Set<Town> towns = railroadNetwork.getTowns();
		assert(towns.size()==3);
		
		Set<Route> routes = railroadNetwork.getRoutes();
		assert(routes.size()==2);
		
	}
	
	@Test
	public void test_add_two_unnconnected_InterTownRoutes() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AB1");
		railroadNetwork.addInterTownRoute("CD2");
		
		Set<Town> towns = railroadNetwork.getTowns();
		assert(towns.size()==4);
		
		Set<Route> routes = railroadNetwork.getRoutes();
		assert(routes.size()==2);
		
	}
	
	@Test
	public void test_add_two_way_interTownRoutes() {
		RailroadNetwork railroadNetwork = new RailroadNetwork();
		railroadNetwork.addInterTownRoute("AB1");
		railroadNetwork.addInterTownRoute("BA2");
		
		Set<Town> towns = railroadNetwork.getTowns();
		assert(towns.size()==2);
		
		Set<Route> routes = railroadNetwork.getRoutes();
		assert(routes.size()==2);
	}
	
}
