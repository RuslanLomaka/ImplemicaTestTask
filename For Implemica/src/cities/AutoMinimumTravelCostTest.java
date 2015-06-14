package cities;

import java.util.HashMap;

public class AutoMinimumTravelCostTest {
	public static void main(String[] args) {

		

		City chernigov = new City("chernigov");
		
		chernigov.setNumber(1);
		chernigov.setTransportCost(2, 20);
		chernigov.setTransportCost(3, 300);
		chernigov.setTransportCost(4, 5);
		
		City sumy = new City("sumy");
		
		sumy.setNumber(2);
		sumy.setTransportCost(1, 20);
		sumy.setTransportCost(4,30);
		sumy.setTransportCost(5, 60);
		
		City kiev = new City("kiev");
		
		kiev.setNumber(3);
		kiev.setTransportCost(1,300);
		kiev.setTransportCost(4, 90);
		kiev.setTransportCost(6, 30);

		
		City poltava = new City("poltava");
		
		poltava.setNumber(4);
		poltava.setTransportCost(1, 5);
		poltava.setTransportCost(2, 30);
		poltava.setTransportCost(3, 90);
		poltava.setTransportCost(5, 100);
		poltava.setTransportCost(6, 50);
	

		City kharkiv = new City("kharkiv");
		
		kharkiv.setNumber(5);
		kharkiv.setTransportCost(2, 60);
		kharkiv.setTransportCost(4, 100);
		kharkiv.setTransportCost(6, 170);
		
		City dnepropetrovsk = new City("dnepropetroovsk");
		
		dnepropetrovsk.setNumber(6);
		dnepropetrovsk.setTransportCost(3, 30);
		dnepropetrovsk.setTransportCost(4, 50);
		dnepropetrovsk.setTransportCost(5, 170);
		
		HashMap<String, City> cities = new HashMap<String, City>();
		
		cities.put(kiev.getName(), kiev);
		cities.put(chernigov.getName(), chernigov);
		cities.put(poltava.getName(), poltava);
		cities.put(sumy.getName(), sumy);
		cities.put(kharkiv.getName(), kharkiv);
		cities.put(dnepropetrovsk.getName(), dnepropetrovsk);

		String source = sumy.getName();
		String destination = kiev.getName();

		int minimumTravelSpends = MinimumTravelCostCalculator
				.calculateMinimumCost(cities, source, destination);

		System.out.println("To get yourself from " + source.toUpperCase()
				+ " to " + destination.toUpperCase() + ",");
		System.out.println("your minimal spend will consist: "
				+ minimumTravelSpends + " UAH");

	}

}
