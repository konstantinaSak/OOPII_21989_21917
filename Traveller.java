import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;

public abstract class Traveller extends City implements Comparable<Traveller> {

	// hardcoded data
	int prefer[] = { 10, 7, 3, 8, 0, 2, 10, 9, 5, 8 }; // 0.cafe, 1.sea, 2.museums, 3.restaurant, 4.stadium, 5.mountain,
														// 6.airplane. 7.desert, 8.sights, 9.camping
	double loc[] = { 37.9795, 23.7162 }; // latitude , longitude of Athens
	int age = 18;
	private long timestamp;
	private double visit;
	ArrayList<Traveller> travellers_array = new ArrayList<Traveller>();
	JacksonTester tester = new JacksonTester();

	@Override
	public int compareTo(Traveller traveller) {
		return this.timestamp.compareTo(traveller.timestamp);
	}

	public class ObjectSort(){
		List<Traveller> travellers = new ArrayList<>();
		travellers.add(new Traveller(0.323132));
		Collections.sort(travellers_array);
	}

		try
		{
			for (int i = 0; i < travellers_array.size(); i++) {
				Traveller traveller;

				Date date = new Date();
				traveller.setTimestamp(date.getTime());
				travellers_array.add(traveller);
				Thread.sleep(i);
			}
			tester.writeJSON(travellers_array);
		}catch(
		JsonParseException e)
		{
			e.printStackTrace();
		}catch(
		JsonMappingException e)
		{
			e.printStackTrace();
		}catch(
		IOException e)
		{
			e.printStackTrace();
		}

        public void writeJSON(ArrayList<Traveller> arrayOfTr) throws JsonGenerationException, JsonMappingException, IOExcepetion{
	         ObjectMapper mapper = new ObjectMapper();
	          mapper.writeValue(new File("arraylist.json"), arrayOfTr);
        }

		public ArrayList<Traveller> readJSON() throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<Traveller> arrayOftr = mapper.readValue(new File("arraylist.json"), ArrayList.class);
			return arrayOftr;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		protected abstract double calculate_similarity(Object City);

		protected double similarity_geodesic_vector(double[] loc, double[] geodesic_vector, String unit) {
			if ((loc[0] == geodesic_vector[0]) && loc[1] == geodesic_vector[1]) {
				return 0;

			} else {
				double theta = loc[1] - geodesic_vector[1];
				double distance = Math.sin(Math.toRadians(loc[0])) * Math.sin(Math.toRadians(geodesic_vector[0]))
						+ Math.cos(Math.toRadians(loc[0])) * Math.cos(Math.toRadians(geodesic_vector[0]))
								* Math.cos(Math.toRadians(theta));
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
				if (travellers.get(i).calculate_similarity(City) > max) { // πολυμορφισμος
					max = travellers.get(i).calculate_similarity(City);
				}
			}
			return max;
		}

}
