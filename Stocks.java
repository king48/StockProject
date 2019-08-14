import java.util.ArrayList;


public class Stocks {
    static ArrayList <String> URL = new ArrayList <String>(); 
    static ArrayList <String>  tickerSym = new ArrayList <String>(); 
    static ArrayList <String>  newSym = new ArrayList <String>(); 
    static ArrayList <String>  stockPrice = new ArrayList <String>(); 
    static ReadFile f = new ReadFile ("file.txt"); 


    public void StockURLs(){
          URL.add (f.getWebsite(3)); 
          URL.add (f.getWebsite(0)); 
          URL.add (f.getWebsite(2)); 
          URL.add (f.getWebsite(1)); 
    }
    public void addTickers(){
        tickerSym.add (f.getStockSymbol(3)); 
        tickerSym.add (f.getStockSymbol(0)); 
        tickerSym.add (f.getStockSymbol(2)); 
        tickerSym.add (f.getStockSymbol(1)); 
    }
    public void getInformation(){
        StockInformation a = new StockInformation(); 
        for (int i = 0 ; i < URL.size(); i ++){
            newSym.add(a.readTicker(tickerSym.get(i), URL.get(i)));
           
        } for (int i = 0 ; i < URL.size(); i ++){
        stockPrice.add(a.readPrice(tickerSym.get(i), URL.get(i)));}
        System.out.println(stockPrice + " "+ newSym);
    }
    public static void main (String [] args){
        Stocks s = new Stocks(); 
        f.openFile();
        f.readThoughFile(); 
        s.StockURLs();
        s.addTickers();
        s.getInformation(); 
        f.closeFile();
    }
}