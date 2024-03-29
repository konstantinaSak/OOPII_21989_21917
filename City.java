import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.connect.spi.Connection;





import java.util.Comparator;

import java.util.Map;





public class City extends Thread {

	private int[] terms_vector;
	private double[] geodesic_vector;
	private String name;
	double res;

	public City(String string) {
		 terms_vector = new int[10];
	     geodesic_vector = new double[2];
	     String name = this.name;
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
	
	//public String toString(){
      //  return this.terms_vector + " " + this.geodesic_vector + " " + this.res ;
    //}
	
	
	
	public void RetrieveData(String city, String country, String appid) throws  IOException {
		 
		 double lat, lon;
		 String text; //������� ��� opendata
		 ObjectMapper mapper = new ObjectMapper();
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 //System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 //System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 lat = weather_obj.getCoord().getLat();
		 lon = weather_obj.getCoord().getLon();
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 //System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
	     text =	mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	     
	     Thread thread1 = new Thread((Runnable) mapper);
	     System.out.println("thread1 start");
	     thread1.start();
	     
	     Thread thread2 = new Thread((Runnable) mediaWiki_obj);
	     System.out.println("thread2 start");
	     thread2.start();
	     
	     terms_vector[0] = (CountWords.countCriterionfCity(text, "cafe")) ; // ��������� ���� �������
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
	     
	    /* Runnable wiki_obj = new Runnable;
	     Thread thread1 = new Thread(wiki_obj);
	     thread1.setDaemon(true);
	     thread1.setName(mediaWiki_obj);
	     System.out.println("Starting wikipedia thread...");
	     thread1.start();
	     
	     Runnable weather = new Runnable(mapper);
	     Thread thread2 = new Thread(weather);
	     thread2.setPriority(Thread.MIN_PRIORITY);
	     thread2.setDaemon(true);
	     System.out.println("Starting open weather map thread...");
	     thread2.start(); */
	 	
	     
	     
	     
	     
	     ArrayList<City> cities = new ArrayList<>();
	 	 HashMap<String,City> hm = new HashMap<String,City>();
	 	
	 	 for(int j=0; j<cities.size(); j++) {
	 		if(hm.containsValue(j)) {
	 			cities.add(null);
	 		}
	 	 }
	 	 
	 	
	 	 
	 	 hm.put("City1", new City("Rome"));
	 	 hm.put("City2", new City("Athens"));
	 	 hm.put("City3", new City("Corfu"));
	 	 hm.put("City4", new City("Berlin"));
	 	 hm.put("City5", new City("Paris"));
	 	 hm.put("City6", new City("Thessaloniki"));
	 	
	 	Set<?> set = hm.entrySet();
	 	Iterator i = (Iterator) set.iterator();
	 	
	 	while(i.hasNext()) {
	 		@SuppressWarnings("rawtypes");
	 		Map.Entry me = (Map.Entry)i.next();
	 		System.out.print("key"+ me.getKey() + ".");
	 		System.out.println("value" + ((City)me.getValue()).getMessage);
	 	}
	 	
	}

	
	static java.sql.Connection db_can_obj = null;
	static PreparedStatement db_prep_obj = null;
	
	private static void JDBCConnection() {
		
		try {
			Class.forName("oracle.jbdc.driver.OracleDriver");
			System.out.println("Your oracle JBDC Driver Registered.");
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry couldn't find your oracle JBDC Driver.");
			e.printStackTrace();
			return;
		}
		
		try {
			db_can_obj = DriverManager.getConnection("jbdc:oracle:thin:@oracle12c.hua.gr:1521:orcl","21917", "21989");
			if(db_can_obj !=null) {
				System.out.println("Connection successful!");
			} else {
				System.out.println("Failed to make a connection.");
			}
		} catch(SQLException e) {
			System.out.println("Oracle connection failed.");
			e.printStackTrace();
			return;
		}
	}
	
	private static void ReadData() throws SQLException {
		
		db_prep_obj = db_can_obj.prepareStatement("Select from city:");
		ResultSet rs = db_prep_obj.executeQuery();
		
		while(rs.next()) {
			 int terms_vector = rs.getInt(0); // edw tha eprepe na baloume ta xarakthristika ths kathe city
			                                  // gia na swthoun sto database.
			
			
		}
		
	}

	
	
	
}

