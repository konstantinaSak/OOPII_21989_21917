
// Age: (25,60]
public class MiddleTraveller extends Traveller {
	
	City city = new City();
   
	
	protected static double similarity_terms_vector(int[] prefer, int[] terms_vector) {
		double result=0.0;
		for(int i=0; i<prefer.length; i++) {
			result = (prefer[i] + terms_vector[i]) / Math.sqrt(Math.pow(prefer[i],2.0)) * Math.sqrt(Math.pow(terms_vector[i],2.0));
		}
		return result;
	}
	
	
	@Override
	protected double calculate_similarity(Object City) {
		double p = 0.5;
		double res;
		res= (p * similarity_terms_vector(prefer , city.getTerms_vector())) + ((1-p) * similarity_geodesic_vector(loc, city.getGeodesic_vector(), "K"));
		city.setRes(res);
		return res;
	}


	
}
