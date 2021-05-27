import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		
		ArrayList<City> cities = new  ArrayList<City>();  
		
		Traveller myTraveller;
		myTraveller =new YoungTraveller(); 
		
        for(int i = 0; i<cities.size(); i++ ) {
		   if (myTraveller.age >= 16 && myTraveller.age <= 25) {
			
			myTraveller.calculate_similarity(cities.get(i));
			
		  } else if (myTraveller.age> 25 && myTraveller.age <= 60) {
			myTraveller =new MiddleTraveller(); 
			myTraveller.calculate_similarity(cities.get(i));
			
		   } else if (myTraveller.age > 60 && myTraveller.age <= 115) {
			myTraveller =new ElderTraveller(); 
			myTraveller.calculate_similarity(cities.get(i));
		   }
        }
		try{
		    	String appid ="98ad73768d0e83675c9c379dd3f76175";
		        City a1 = new City();
		        cities.add(a1);
		        a1.RetrieveData("Rome","it",appid);	
		        //System.out.println(a1.getTerms_vector());
		        City a2 = new City();
		        cities.add(a2);
			    a2.RetrieveData("Athens","gr",appid);
			    City a3 = new City();
			    cities.add(a3);
			    a3.RetrieveData("Corfu","gr",appid);
			    City a4 = new City();
			    cities.add(a4);
			    a4.RetrieveData("Berlin","de",appid);
			    City a5 = new City();
			    cities.add(a5);
			    a5.RetrieveData("Paris","fr",appid);
			    City a6 = new City();
			    cities.add(a6);
                a6.RetrieveData("Thessaloniki","gr",appid);
                
		    }catch(IOException e) {
		    	System.out.println("There is no information for all cities" );
		    	
		    }
		
		Object max = myTraveller.compare_cities(cities);
		System.out.println("City with max similarity" + max.toString());
		ArrayList<City> next = new ArrayList<City>();
		
		int k = 4;
	    while(k>=2 && k<=5) {
	    	
	    	next = myTraveller.compare_cities(cities, k);
	    }
	    
	   
	}		

}



