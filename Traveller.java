
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.Object;
//import org.springframework.boot.test.json;
//import org.springframework.boot.test.json.JacksonTester;
import java.sql.Date;


public abstract class Traveller extends City {

	



	// hardcoded data
	int prefer[] = { 10, 7, 3, 8, 0, 2, 10, 9, 5, 8 }; // 0.cafe, 1.sea, 2.museums, 3.restaurant, 4.stadium, 5.mountain,
														// 6.airplane. 7.desert, 8.sights, 9.camping
	double loc[] = { 37.9795, 23.7162 }; // latitude , longitude of Athens
	int age = 10;
	private long timestamp;
	private String visit;
	private int[] Criteria = new int[8];
	public static final int MAX_CITIES = 5;
    private String[] candidate_cities = new String[MAX_CITIES];
	ArrayList<Traveller> travellers_array = new ArrayList<>();

	public Traveller(String string) throws InvalidAgeException {
		super(string);
		if(age<16 || age>115) {
			throw new InvalidAgeException("age can not be under 16 and over 115");
		}else {
			this.age = age;
		}
   
	
	//JacksonTester tester = new JacksonTester();

	//public long compareTo(Traveller traveller) {
		//return this.timestamp.compareTo(traveller.timestamp);
	//}

	/*public void ObjectSort(){
		List<Traveller> travellers = new ArrayList<>();
		travellers.add(new YoungTraveller());
		Collections.sort( travellers_array);
	}*/

	try{
			for (int i = 0; i < travellers_array.size(); i++) {
				Traveller traveller;

				Date date = new Date(timestamp);
				traveller.setTimestamp(date.getTime());
				travellers_array.add(traveller);
				Thread.sleep(i);
			}
			//tester.writeJSON(travellers_array);
		}catch(
		JsonParseException e1)
		{
			e1.printStackTrace();
		}catch(
		JsonMappingException e2)
		{
			e2.printStackTrace();
		}catch(
		IOException e)
		{
			e.printStackTrace();
		}

       

		public  void writeJSON(ArrayList<Object> arrayOfTr ) throws JsonGenerationException, JsonMappingException, IOException  { 
        
	         ObjectMapper mapper = new ObjectMapper();
	         mapper.writeValue(new File("arraylist.json"), arrayOfTr);
        }

		public ArrayList<Traveller> readJSON() throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<Traveller> arrayOftr = mapper.readValue(new File("arraylist.json"), ArrayList.class);
			return arrayOftr;
		}
		
		 public int[] getCriteria() {
				return Criteria;
			}

			public void setCriteria(int[] criteria) {
				Criteria = criteria;
			}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		
		public String getVisit() {
			return visit;
		}

		public void setVisit(String string) {
			this.visit = string;
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
			for (int i = 0; i < cities.size(); i++) {
				System.out.println(toString());
			}
			Collections.sort(cities, new Sortbyres()); // ταξινομηση στο cities με βαση το similarity
			System.out.println("\nSorted by similarity");
			for (int i = 0; i < cities.size(); i++) {
				System.out.println(toString());
			}
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

		class Sortbyres implements Comparator<City>{
			   public int compare(City a, City b){
			       
				   return (int) (b.res - b.res);
			    }
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
		
		private static int innerDot(int[] currentTraveller, int[] candidateTraveller) {
			int sum=0;
			for (int i=0; i<currentTraveller.length;i++)
				sum+=currentTraveller[i]*candidateTraveller[i];
			return sum;
				
		}

		Random r = new Random();
		for (int i=0; i<100; i++) {	//We add 100 historical Travelers in the Collection.
			Traveller curTraveller = new Traveller("Traveller_"+Integer.toString(i),r.nextInt(90),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2));  		
			curTraveller.setVisit("City_"+Integer.toString(i)); //Will the Traveler_i visit the City_i ?
			travellers.add(curTraveller);		
		}	
		System.out.println(collectionTravellers);
		
		//We have a new candidate traveler.
		Traveller candidateTraveller = new Traveller("Traveller_Candidate",r.nextInt(90),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2),r.nextInt(2));  		
		int[] candidateTravellerCriteria=candidateTraveller.getCriteria(); //The criteria of the candidate traveler.
		
		//We see for each city what is the rank of similarity (dot product) between the candidate Traveller criteria and all the Travellers of the Collection.
		Map <String,Integer> cityToRank= travellers.stream().collect(Collectors.toMap(i->i.getVisit(),i->innerDot(i.getCriteria(),candidateTravellerCriteria)));
		cityToRank.forEach((k,v)->System.out.println("city:"+k+" rank: "+v));
		
		//We print the Traveller who has the highest Rank (similarity) (dot product).
		Optional<RecommendedCity> recommendedCity=
				travellers.stream().map(i-> new RecommendedCity(i.getVisit(),innerDot(i.getCriteria(),candidateTravellerCriteria))).max(Comparator.comparingInt(RecommendedCity::getRank));
				
		System.out.println("The Recommended City:"+recommendedCity.get().getCity());

		
}
