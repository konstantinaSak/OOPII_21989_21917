
public class CountWords {
	
	public static int countCriterionfCity(String cityArticle, String criterion) {
		cityArticle=cityArticle.toLowerCase();
		int index = cityArticle.indexOf(criterion);
		int count = 0;
		while (index != -1) {
		    count++;
		    cityArticle = cityArticle.substring(index + 1);
		    index = cityArticle.indexOf(criterion);
		}
		return count;
	}


	

}
