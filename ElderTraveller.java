
// Age: (60,115]
public class ElderTraveller extends Traveller{
	
    City city = new City();
	
    public static double similarity_terms_vector(int[] prefer, int[] terms_vector) {

    	int union=0;
        int intersection=0;
        for (int i=0; i<prefer.length; i++) {
        	if(prefer[i]>0 || terms_vector[i]>0) union++;
            	if(prefer[i]>0 && terms_vector[i]>0) intersection++;
        }
        if (union==0) 
        	return 0;
        else
            return (double)intersection/union;
    }
    
    
    
	
	
	
	@Override
	protected double calculate_similarity(Object City) {
		double p = 0.2;
		double res;
		res= (p * similarity_terms_vector(prefer, city.getTerms_vector())) + ((1-p) * similarity_geodesic_vector(loc, city.getGeodesic_vector(), "K"));
		city.setRes(res);
		return res;
		
	}

}
