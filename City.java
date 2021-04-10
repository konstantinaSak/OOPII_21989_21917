import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

public class City {

	private ArrayList<Integer> terms_vector;
	private ArrayList<Double> geodesic_vector;

	public City() {
		 terms_vector = new ArrayList<Integer>() ;
	     geodesic_vector = new ArrayList<Double>();
	}

	public ArrayList<Integer> getTerms_vector() {
		return terms_vector;
	}

	public void setTerms_vector(ArrayList<Integer> terms_vector) {
		this.terms_vector = terms_vector;
	}

	public  ArrayList<Double> getGeodesic_vector() {
		return geodesic_vector;
	}

	public void setGeodesic_vector(ArrayList<Double> geodesic_vector) {
		this.geodesic_vector = geodesic_vector;
	}

	public void RetrieveData(String city, String country, String appid) throws  IOException {
		 
		 double lat, lon;
		 String text;
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 //System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 //System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 lat = weather_obj.getCoord().getLat();
		 lon = weather_obj.getCoord().getLon();
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 //System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
	     text =	mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	     //City vectors = new City();
	     
	     terms_vector.add(CountWords.countCriterionfCity(text, "cafe") );
	     terms_vector.add(CountWords.countCriterionfCity(text, "sea"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "museums"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "restaurant"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "stadium"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "mountain"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "airplane"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "desert"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "sights"));
	     terms_vector.add(CountWords.countCriterionfCity(text, "camping"));
	     geodesic_vector.add(lat);
	     geodesic_vector.add(lon);
	     setTerms_vector(terms_vector);
	     setGeodesic_vector(geodesic_vector);
	     System.out.println(getTerms_vector());
	     System.out.println(getGeodesic_vector());
	     
	 }
	
		
     


}
