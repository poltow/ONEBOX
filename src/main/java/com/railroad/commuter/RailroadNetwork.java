package com.railroad.commuter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RailroadNetwork {

	private Set<Town> towns = new HashSet<>();
	private Set<Route> routes = new HashSet<>();

	public Set<Town> getTowns() {
		return towns;
	}

	public Set<Route> getRoutes() {
		return routes;
	}

	public Set<Route> getOutgoingRoutesForTown(String townName) {
		return getTown(townName).getOutgoingRoutes();
	}
	
	public void addInterTownRoute(String interTownRouteInfo) {

		validateInterTownRouteInfoFormat(interTownRouteInfo);

		String originName = interTownRouteInfo.substring(0, 1);
		String destinationName = interTownRouteInfo.substring(1, 2);
		int routeDistance = Integer.parseInt(interTownRouteInfo.substring(2));

		validateInterTownRouteInfoValues(originName, destinationName, routeDistance);

		Town originTown = new Town(originName);
		Town destinationTown = new Town(destinationName);
		Route route = new Route(originTown, destinationTown, routeDistance);

		validateDuplicatedRoutes(route);

		addTownAndRouteToRailroadNetwork(originTown, destinationTown, route);
	}
	
	private void validateInterTownRouteInfoFormat(String interTownRouteInfo) {
		if (interTownRouteInfo == null)
			throw new NullPointerException();
		if (interTownRouteInfo.isEmpty())
			throw new IllegalArgumentException("Input is empty");
		if (!interTownRouteInfo.matches("[A-Z]{2}[0-9]+"))
			throw new IllegalArgumentException("Input should match the '[A-Z]{2}[0-9]+' regex");
	}
	
	private void validateInterTownRouteInfoValues(String originName, String destinationName, int routeDistance) {
		if (originName.equals(destinationName))
			throw new IllegalArgumentException("A Route must connect two different Towns");

		if (routeDistance <= 0)
			throw new IllegalArgumentException("A Route distance must be greater than 0");
	}

	private void validateDuplicatedRoutes(Route route) {
		if (routes.contains(route))
			throw new IllegalArgumentException("Routes cannot be duplicated");
	}
	
	private void addTownAndRouteToRailroadNetwork(Town originTown, Town destinationTown, Route route) {
		
		if (!towns.contains(originTown)) {
			originTown.addOutgoingRoute(route);
			towns.add(originTown);
		} else {
			addNewOutgoingRouteToTown(originTown.getName(), route);
		}
		
		if (!towns.contains(destinationTown))
			towns.add(destinationTown);

		routes.add(route);
	}
	
	private void addNewOutgoingRouteToTown(String townName, Route route) {
		getTown(townName).addOutgoingRoute(route);
	}

	private Town getTown(String townName) {
		for (Iterator<Town> it = towns.iterator(); it.hasNext();) {
			Town town = it.next();
			if (townName.equals(town.getName()))
				return town;
		}
		throw new IllegalStateException("Error retrieving " + townName);
	}
}
