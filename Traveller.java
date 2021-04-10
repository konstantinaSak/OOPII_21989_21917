

public abstract class Traveller {
	
	// hardcoded data
	int prefer[] = {10, 7, 3, 8, 0, 2, 10, 9, 5, 8}; //0.cafe, 1.sea, 2.museums, 3.restaurant, 4.stadium, 5.mountain, 6.airplane. 7.desert, 8.sights, 9.camping
    double loc[] = {37.9795, 23.7162}; // latitude , longitude of Athens
    int age = 18;
    
    protected abstract int calculate_similarity( Object City);

}
