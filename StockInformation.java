import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL; 
import java.net.URLConnection; 
/*<--------------------------->*/
import java.util.ArrayList;

//code taken from https://www.youtube.com/watch?v=UVqjMbYlCFs
//this code will work for yahoo mostly 
//https://www.nasdaq.com/symbol/ko/real-time

public class StockInformation {
    public String price = "No data";
    public String ticker = "No Ticker"; 
    
    public void indenfityTarget (String first, String second){
        
    }
    public String readPrice (String companyName, String website){

        try {
              URL url = new URL(website); 
              URLConnection urlConn = url.openConnection (); 
              InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream()); 
              BufferedReader buff = new BufferedReader(inStream); 
              String line = buff.readLine(); 

              while (line != null){            
                   if (line.contains("root.App.main = {\"context\"")){
                      int target = line.indexOf ("\"regularMarketPrice\":{\"raw\":"); 
                      int decimal = line.indexOf (".", target);  
                      int start = decimal; 
                      while (line.charAt(start) != '\"'){
                          start --; 
                      }
                      price = line.substring (start +2 , decimal+3 ); 
                   }          
                  line=buff.readLine(); 
              }
          }catch(Exception IOException){
              System.out.println("Something is wrong"); 
          }
          System.out.println(price);
          return price; 
     }
    public String readTicker(String companyName, String website){
        try {
            URL url = new URL(website); 
            URLConnection urlConn = url.openConnection (); 
            InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream()); 
            BufferedReader buff = new BufferedReader(inStream); 
            String line = buff.readLine(); 
           
            while (line != null){            
                 if (line.contains("root.App.main = {\"context\"")){
                    int target = line.indexOf ("\"EQUITY\",\"symbol\"");   // ("\"regularMarketPrice\":{\"raw\":"); 
                    
                    int decimal = line.indexOf (".", target);  
                    int start = decimal; 
                    while (line.charAt(start) != '\"'){
                        start --; 
                    }
                    ticker = line.substring (start +2 , decimal+3 ); 
                 }          
                line=buff.readLine(); 
            }
            for (int i = 0; i < ticker.length(); i++){
                if (ticker.charAt(i) == ',' ){
                    System.out.println ("Need Change, there is a comma in this stock " + companyName); 
                }
            }
        }catch(Exception IOException){
            System.out.println("Something is wrong"); 
        }
        System.out.println(ticker);
        return ticker; 
    }

}