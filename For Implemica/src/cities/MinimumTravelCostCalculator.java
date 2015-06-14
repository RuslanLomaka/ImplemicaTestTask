package cities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Ruslan Lomaka;
 * @Description calculates minimum travel cost according to the Dijcstra
 *              algotithm
 *	https://en.wikipedia.org/?title=Dijkstra%27s_algorithm
 */

public class MinimumTravelCostCalculator {
	
	private static HashMap<String, City> cities;

	private static City host;

	
	/**
	 * Loop iterate through all neoghbours of host. It compares travel
	 * cost from current host to that city and travel cost which is stored
	 * in that city, and further set the minimal cost to that city.
	 */
	private static void iterateThroughNeighbours() {
		
		for (Entry<Integer, Integer> neighborEntry : host.neighbors.entrySet()) {

			City loopNeighbor = null;
			for (Entry<String, City> cityEntry : cities.entrySet()) {
				if (cityEntry.getValue().getNumber() == neighborEntry.getKey()) {
					loopNeighbor = cityEntry.getValue();
				}

			}

			int travelCostFromHost = host.getMinimumTravelCost()
					+ host.getTransportCost(loopNeighbor.getNumber());
			//System.out.println("from " + host.getName().toUpperCase() + " to "
			//		+ loopNeighbor.getName().toUpperCase() + " : "
			//		+ travelCostFromHost);

			if (travelCostFromHost < loopNeighbor.getMinimumTravelCost()) {
				loopNeighbor.setMinimumTravelCost(travelCostFromHost);
			}
		}
	}

	private static boolean unvisitedCitiesPresent() {
		boolean atLeastOneFlag = false;
		//System.out.println("Flags and mimimum costs:");
		for (Entry<String, City> cityEntry : cities.entrySet()) {
			City loopCity = cityEntry.getValue();

			//System.out.println(loopCity.getName().toUpperCase() + " flag: "
			//		+ loopCity.isFlag() + " cost: "
			//		+ loopCity.getMinimumTravelCost());
			if (!loopCity.isFlag()) {
				atLeastOneFlag = true;
			}
		}

		return atLeastOneFlag;
	};

	private static void getNewHost() {
		ArrayList<City> sortedCities = new ArrayList<City>();

		for (Entry<String, City> cityEntry : cities.entrySet()) {
			if (!cityEntry.getValue().isFlag()) {
				sortedCities.add(cityEntry.getValue());
			}

		}

		sortedCities.sort(new Comparator<City>() {
			@Override
			public int compare(City o1, City o2) {
				return o1.getMinimumTravelCost() - o2.getMinimumTravelCost();
			}

		});
		//System.out.println("Sorted heihgbors of "
		//		+ host.getName().toUpperCase() + " " + sortedCities);
		try {
			host = sortedCities.get(0);
		} catch (IndexOutOfBoundsException e) {
		}
		//System.out
		//		.println("----------------------------------------------------------------");
		//System.out.println("New host is " + host.getName().toUpperCase());
	}
	/**
	 * @param cities- contains cites map with straight connections betwen them,
	 * 		  and transport costs of that connections
	 * @param sourceString- the name of source city
	 * @param destinationString- the name of destination city
	 * @return calculated minimal spends that are reqired to getfrom source to
	 *        destination
	 */
	public static int calculateMinimumCost(HashMap<String, City> inputCities,
			String sourceString, String destinationString) {
		cities = inputCities;

		System.out.println("ALL CITIES MAP:");
		System.out.println(cities);
		City sourceCity = inputCities.get(sourceString);;
		City destinationCity = inputCities.get(destinationString);

		host = sourceCity;

		//System.out.println("Setting minimum transport cost to source city 0");
		host.setMinimumTravelCost(0);

		//System.out.println("Setting flag of current host city to true");
		host.setFlag(true);

		//System.out.println("Destination city: " + destinationCity);
		//System.out.println("Source city: " + sourceCity);

		while (unvisitedCitiesPresent()) {
			//System.out.println();
			//System.out.println("Getting neighbors neighbors of "
			//		+ host.getName().toUpperCase());
			iterateThroughNeighbours();
			//System.out.println("Setting flag of current host city to true");
			host.setFlag(true);
			//System.out.println("Check if there is unvisited cities :");
			getNewHost();
		}
		return destinationCity.getMinimumTravelCost();
	}

}