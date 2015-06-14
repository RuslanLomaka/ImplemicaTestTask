package cities;

import java.util.HashMap;

/**
 * @author Ruslan Lomaka;
 * @Description Contains full information about city, that is necessary for
 *              calculation of travel cost "from", "to" and
 *              "through city". Information about neighbor city stored in
 *              HashMap neighbors K(Integer),V(Integer), thats mean the number of neighbor
 *              city and cost of transport respectively.
 */
class City {
	HashMap<Integer, Integer> neighbors = new HashMap<Integer, Integer>();
	private String name;
	private int number;
	private int minimumTravelCost;
	private boolean flag;

	public City(String cityName) {
		this.name = cityName;
		minimumTravelCost = 200000;
		flag = false;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getNeigborsQuantity() {
		return this.neighbors.size();
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setMinimumTravelCost(int minimumTravelCost) {
		this.minimumTravelCost = minimumTravelCost;
	}

	public int getMinimumTravelCost() {
		return minimumTravelCost;
	}

	/**
	 * Sets transport cost to the neighbor city by number of that city.
	 * @param cityNumber- the number of the neighbor city.
	 * @param cost- cost of transport to that city.
	 * @return true if successful, false - if fail;
	 */
	public boolean setTransportCost(int cityNumber, int cost) {
		if (!neighbors.keySet().contains(cityNumber)) {
			neighbors.put(cityNumber, cost);
			return true;
		} else {
			System.err.println("Be careful. That city has already defined.");
			return this.setTransportCost(cityNumber, cost);
		}
	}

	/**
	 * @param cityNumber
	 * @return the cost of transport to the city, which number was input.
	 */
	public int getTransportCost(int cityNumber) {
		if (!neighbors.keySet().contains(cityNumber)) {
			return 0;
		} else {
			return neighbors.get(cityNumber);
		}
	}
	/**
	 * @param potentialNeighborCity
	 * @return true, if this city has input city in the HashMap neighbors <Integer,Integer>
	 */
	public boolean hasThisNeighbor(City potentialNeighborCity) {
		if (this.neighbors.containsKey(potentialNeighborCity.getNumber())) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "City [name=" + name + ", flag=" + flag + ", number=" + number
				+ ", neigboursQuantity=" + this.neighbors.size()
				+ ", minimumTravelCost=" + minimumTravelCost + ", neighbors="
				+ neighbors + "]";
	}
}