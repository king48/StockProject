/*import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; */

import java.io.*; 
import java.util.*; 

public class ReadFile{
    private Scanner x;
    protected String fileName = "file.txt";  
    public List <String> stockName = new ArrayList<String>(); 
    public List <String> tickerSym = new ArrayList<String>(); 
    public List <String> stockPrice = new ArrayList<String>(); 
    public List <String> sharesOut = new ArrayList<String>(); 
    public List <String> stockSite = new ArrayList<String>(); 


    public ReadFile(String fileName){
        this.fileName = fileName;  
    }
    public void openFile (){
        try {
            x = new Scanner (new File(fileName)); // remember to add .txt at the end of the file name 
        } catch (Exception IOException){
            System.out.println ("Something is wrong (OpeningFile - reading)"); 

        }
    }
    public void readThoughFile (){
        try{        
            while (x.hasNext ()){
                stockName.add(x.next()); 
                tickerSym.add(x.next());  
                stockPrice.add(x.next());  
                sharesOut.add(x.next()); 
                stockSite.add(x.next()); 

                System.out.println ( stockName );  
                System.out.println ( tickerSym );  
                System.out.println ( stockPrice );  
                System.out.println ( sharesOut );  
                System.out.println ( stockSite );
            }
        }catch (Exception IOException){
            System.out.println ("Something is wrong (ReadingFile)"); 
        }
    }
    public void closeFile(){
        x.close(); 
    }
    public String getStockName(int index){
        return stockName.get(index); 
    }
    public String getStockSymbol (int index){
        return tickerSym.get(index);
    }
    public String getStockPrice(int index){
        return stockPrice.get(index);
    }
    public String getSharesOut (int index){
        return sharesOut.get(index);
    }
    public String getWebsite (int index){
        return stockSite.get(index);
    }
   public static void main (String [] args){
        ReadFile r = new ReadFile("file.txt"); 
        r.openFile(); 
        r.readThoughFile();
        r.closeFile();
    }//*/
}
