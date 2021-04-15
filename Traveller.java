import java.util.ArrayList;
import java.util.Collections;

public abstract class Traveller extends City {

	// hardcoded data
	int prefer[] = { 10, 7, 3, 8, 0, 2, 10, 9, 5, 8 }; // 0.cafe, 1.sea, 2.museums, 3.restaurant, 4.stadium, 5.mountain,
														// 6.airplane. 7.desert, 8.sights, 9.camping
	double loc[] = { 37.9795, 23.7162 }; // latitude , longitude of Athens
	int age = 18;

	protected abstract double calculate_similarity(Object City);

	protected double similarity_geodesic_vector(double[] loc, double[] geodesic_vector, String unit) {
		if ((loc[0] == geodesic_vector[0]) && loc[1] == geodesic_vector[1]) {
			return 0;

		} else {
			double theta = loc[1] - geodesic_vector[1];
			double distance = Math.sin(Math.toRadians(loc[0])) * Math.sin(Math.toRadians(geodesic_vector[0]))
					+ Math.cos(Math.toRadians(loc[0])) * Math.cos(Math.toRadians(geodesic_vector[0]))* Math.cos(Math.toRadians(theta));
			distance = Math.acos(distance);
			distance = Math.toDegrees(distance);
			distance = distance * 60 * 1.1515;
			if (unit.equals("K")) {
				distance = distance * 1.609344;
			} else if (unit.equals("N")) {
				distance = distance * 0.8684;
			}
			return (distance);
		}
	}

	public Object compare_cities(ArrayList<City> cities) {
		Collections.sort(cities, new Sortbyres()); // ταξινομηση στο cities με βαση το similarity 
		System.out.println("\nSorted by similarity");
		for (int i = 0; i < cities.size(); i++)
			System.out.println(toString());

		return cities.get(0);
	}

	public ArrayList<City> compare_cities(ArrayList<City> cities, int k) { // υπερφορτωση
		Collections.sort(cities, new Sortbyres());
		ArrayList<City> next = new ArrayList<City>();
		for (int i = 2; i <= k; i++) {
			next.add(cities.get(i));

		}
		return next;

	}

	ArrayList<Traveller> travellers = new ArrayList<Traveller>();
    
	public double freeTicket(Object City) {
		double max = travellers.get(0).calculate_similarity(City);
		for (int i = 0; i < travellers.size(); i++) {
			if (travellers.get(i).calculate_similarity(City) > max) { //πολυμορφισμος
				max = travellers.get(i).calculate_similarity(City);
			}
		}
		return max;
	}



}
