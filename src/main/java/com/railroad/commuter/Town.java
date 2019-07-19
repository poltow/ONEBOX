package com.railroad.commuter;

import java.util.HashSet;
import java.util.Set;

public class Town {

	private String name;

	private Set<Route> outgoingRoutes;

	public Town(String name) {
		this.name = name;
		outgoingRoutes = new HashSet<>();
	}

	public void addOutgoingRoute(Route route) {
		outgoingRoutes.add(route);
	}

	public String getName() {
		return name;
	}

	public Set<Route> getOutgoingRoutes() {
		return outgoingRoutes;
	}

	@Override
	public int hashCode() {
		final int prime = 37;
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
		Town other = (Town) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
