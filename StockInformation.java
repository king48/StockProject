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
    
    public String price = "No data";; 
    public static ArrayList <String> companyPrices = new ArrayList <String>();
    //{"rvt":"MFC.TO" is vital for the stock ticker symbol use the .  
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
            for (int i = 0; i < price.length(); i++){
                if (price.charAt(i) == ',' ){
                    System.out.println ("Need Change, there is a comma in this stock " + companyName); 
                }
            }
        }catch(Exception IOException){
            System.out.println("Something is wrong"); 
        }
        System.out.println(price);
        return price; 
    }


   /* public static void main (String [] args) {
        StockInformation r = new StockInformation(); 
        companyPrices.add(r.readPrice("TD",TD));
        companyPrices.add(r.readPrice("Manulife",MFC));
        companyPrices.add(r.readPrice("IDK",UTX)); 
        System.out.println(companyPrices);
    }*/
}