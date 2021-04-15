
// Age: [16,25]
public class YoungTraveller extends Traveller{
	
	
	City city = new City();
	
	protected static double similarity_terms_vector(int[] prefer, int[] terms_vector) {
		double number=0.0;
		double result;
		for(int i=0; i<prefer.length; i++) {
			number = number +Math.pow((prefer[i] - terms_vector[i]), 2);
		}
		Math.sqrt(number);
		result = 1 / (1 + number);
		return result;
	}
	
	@Override
	protected double calculate_similarity(Object City) {
		double p = 0.8;
		double res;
		res= (p * similarity_terms_vector(prefer, city.getTerms_vector())) + ((1-p) * similarity_geodesic_vector(loc, city.getGeodesic_vector(), "K"));
		city.setRes(res);
		return res;
	}
	
	

}
