package cities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 
 * @author RuslanLomaka
 * 
 * 			 This class get the minimal possible price to get from one city to other
 *       Note, that running this programm You must to input data very carefully
 *       according to some weighted graph. That is not allowed to make links
 *       with negative weights.
 */
public class ManualMinimumTravelCostTest {
	public static City buildCity(String cityName, int cityNumber) {
		City city = new City(cityName);

		int NeigborsQuantity = Integer.parseInt(input());
		System.out.println("Pleale input name of city #" + cityNumber + "...");
		System.out.println("Pleale input number of neigbor cities of city #"
				+ cityNumber + "...");
		
		/*filling the internal data of city instance
		 *  with informarion about neighbors*/
		for (int j = 0; j < NeigborsQuantity; j++) {
			System.out
					.println("Pleale input the distance to the neigbor city #"+ (j+1));
			System.out
					.println("in the folloving format: [city number] [travel cost]...");
			String[] stringInput = input().split(" ");

			city.setTransportCost(Integer.parseInt(stringInput[0]),
					Integer.parseInt(stringInput[1]));
			city.setNumber(cityNumber);
		}
		return city;
	}

	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	};

	public static String input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stringInput = null;
		try {
			stringInput = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringInput;

	};

	//MAIN METHOD-----------------------------
	public static void main(String[] args) {
		HashMap<String, City> cities;
		int testsQuantity;
		int citiesQuantity;

		System.out.println("Pleale input number of tests...");
		testsQuantity = Integer.parseInt(input());

		System.out.println("Pleale input number of cities...");
		citiesQuantity = Integer.parseInt(input());

		cities = new HashMap<String, City>();

		/* Creating cities map in manual mode.
		 * This step demand precision from user */
		for (int i = 0; i < citiesQuantity; i++) {
			String cityName = input();
			City city = buildCity(cityName, (i + 1));
			cities.put(cityName, city);
		}

		/* For input input of tests have fun with my program.
		 * It requires to type cities name in one row with one space betwen them */
		for (int i = 0; i < testsQuantity; i++) {
			System.out
					.println("Pleale input the source and destination cities names in row to get happines"
							+ (i + 1) + "...");
			String sourceAndDestination = input();
			String source = sourceAndDestination.split(" ")[0];
			String destination = sourceAndDestination.split(" ")[1];
			int resultMinimumCost = MinimumTravelCostCalculator
					.calculateMinimumCost(cities, source, destination);
			System.out.println(resultMinimumCost);
		}
	}
}