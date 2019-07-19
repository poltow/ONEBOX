package com.railroad.commuter;

import java.util.Set;

public class RailroadCommuter {

	private RailroadNetwork railroadNetwork;

	public RailroadCommuter(RailroadNetwork railroadNetwork) {
		this.railroadNetwork = railroadNetwork;
	}

	public String calculatePathDistanceFor(String townSequence) {

		validateRailroadNetworkState();
		validateRouteSequenceFormat(townSequence);

		String[] townNameArray = townSequence.split("-");
		
		validateTownsAreInRailroadNetwork(townNameArray);

		int result = computeTotalDistanceForTownSequence(townNameArray);

		return result > 0 ? String.valueOf(result) : "NO SUCH ROUTE";
	}

	private void validateRailroadNetworkState() {
		if (railroadNetwork.getRoutes().isEmpty())
			throw new IllegalStateException("RailroadNetwork is empty");
	}

	private void validateRouteSequenceFormat(String routeSequence) {
		if (!routeSequence.matches("[A-Z]-[A-Z]((-[A-Z])*)"))
			throw new IllegalArgumentException("Input should match the '[A-Z]-[A-Z]((-[A-Z])*)' regex");
	}

	private void validateTownsAreInRailroadNetwork(String[] townNameArray) {
		for (String townName : townNameArray) {
			if (!railroadNetwork.getTowns().contains(new Town(townName)))
				throw new IllegalArgumentException(townName + "don't belong to RailroadNetwork");
		}
	}

	private int computeTotalDistanceForTownSequence(String[] townNameArray) {
		int result = 0;
		for (int i = 0; i < townNameArray.length - 1; i++) {
			int minDistanceBetween = getDistanceBetweenTowns(townNameArray[i], townNameArray[i + 1]);
			if (minDistanceBetween == 0)
				return 0;
			result += minDistanceBetween;
		}
		return result;
	}

	private int getDistanceBetweenTowns(String townFrom, String townTo) {
		Set<Route> outgoingRoutesForTown = railroadNetwork.getOutgoingRoutesForTown(townFrom);
		for (Route route : outgoingRoutesForTown) {
			if (townTo.contentEquals(route.getDestination().getName()))
				return route.getDistance();
		}
		return 0;
	}
}