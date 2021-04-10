import java.io.IOException;

public class Main extends City  {
	
	public static void main(String[] args) throws IOException  {
		    try{
		    	String appid ="98ad73768d0e83675c9c379dd3f76175";
		        City a1 = new City();
		        a1.RetrieveData("Rome","it",appid);	
		        //System.out.println(a1.getTerms_vector());
		        City a2 = new City();
			    a2.RetrieveData("Athens","gr",appid);
			    City a3 = new City();
			    a3.RetrieveData("Corfu","gr",appid);
			    City a4 = new City();
			    a4.RetrieveData("Berlin","de",appid);
			    City a5 = new City();
			    a5.RetrieveData("Amsterdam","de",appid);
			    City a6 = new City();
                a6.RetrieveData("Barcelona","de",appid);
                
		    }catch(IOException e) {
		    	System.out.println("There is no information for all cities" );
		    	
		    }
		
		

	}

	
		
	}


