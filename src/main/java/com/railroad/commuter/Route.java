package com.railroad.commuter;

public class Route {

	private final String name;
	private final Town destination;
	private final int distance;
	
	public Route(Town source, Town destination, int distance) {
		this.name = source.getName() + "" + destination.getName();
		this.destination = destination;
		this.distance = distance;
	}

	public Town getDestination() {
		return destination;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}

		return true;
	}
}
