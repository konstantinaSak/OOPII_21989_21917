import java.io.IOException;
import java.net.URL;
import java.util.Comparator;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

public class City  {

	private int[] terms_vector;
	private double[] geodesic_vector;
	private double res;

	public City() {
		 terms_vector = new int[10];
	     geodesic_vector = new double[2];
	     res = 0;
	}
	
	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}


	public int[] getTerms_vector() {
		return terms_vector;
	}

	public void setTerms_vector(int[] terms_vector) {
		this.terms_vector = terms_vector;
	}

	public  double[] getGeodesic_vector() {
		return geodesic_vector;
	}

	public void setGeodesic_vector(double[] geodesic_vector) {
		this.geodesic_vector = geodesic_vector;
	}
	
	public String toString(){
        return this.terms_vector + " " + this.geodesic_vector + " " + this.res ;
    }
	
	public void RetrieveData(String city, String country, String appid) throws  IOException {
		 
		 double lat, lon;
		 String text; //κωδικας απο opendata
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 //System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 //System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 lat = weather_obj.getCoord().getLat();
		 lon = weather_obj.getCoord().getLon();
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 //System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
	     text =	mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	     
	     terms_vector[0] = (CountWords.countCriterionfCity(text, "cafe")) ; // γεμιζουμε τους πινακες
	     terms_vector[1] = (CountWords.countCriterionfCity(text, "sea"));
	     terms_vector[2] = (CountWords.countCriterionfCity(text, "museums"));
	     terms_vector[3] = (CountWords.countCriterionfCity(text, "restaurant"));
	     terms_vector[4] = (CountWords.countCriterionfCity(text, "stadium"));
	     terms_vector[5] = (CountWords.countCriterionfCity(text, "mountain"));
	     terms_vector[6] = (CountWords.countCriterionfCity(text, "airplane"));
	     terms_vector[7] = (CountWords.countCriterionfCity(text, "desert"));
	     terms_vector[8] = (CountWords.countCriterionfCity(text, "sights"));
	     terms_vector[9] = (CountWords.countCriterionfCity(text, "camping"));
	     geodesic_vector[0] = (lat);
	     geodesic_vector[1] = (lon);
	     setTerms_vector(terms_vector); // encapsulation
	     setGeodesic_vector(geodesic_vector);
	     //System.out.println(getTerms_vector());
	     //System.out.println(getGeodesic_vector());
	     
	 }

	public class Sortbyres implements Comparator<City>{
	   public int compare(City a, City b){
	       
		   return (int) (a.res - b.res);
	    }
	}

	
	
	
		
     


}
