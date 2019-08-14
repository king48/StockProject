import java.util.ArrayList;


public class Stocks {
    static ArrayList <String> URL = new ArrayList <String>(); 
    static ArrayList <String>  tickerSym = new ArrayList <String>(); 
    static ArrayList <String>  stockPrice = new ArrayList <String>(); 
    
    String UTX = "https://ca.finance.yahoo.com/quote/UTX?p=UTX&.tsrc=fin-srch";
    String TD = "https://ca.finance.yahoo.com/quote/TD.TO?p=TD.TO&.tsrc=fin-srch";
    String MFC  = "https://ca.finance.yahoo.com/quote/MFC.TO/key-statistics?p=MFC.TO";
    String TSLA = "https://ca.finance.yahoo.com/quote/TSLA?p=TSLA&.tsrc=fin-srch";

    public void StockURLs(){
          URL.add (UTX); 
          URL.add (TD); 
          URL.add(MFC); 
          URL.add(TSLA); 
    }
    public void addTickers(){
        tickerSym.add(UTX); 
        tickerSym.add(TD); 
        tickerSym.add(MFC); 
        tickerSym.add(TSLA); 
    }
    public void getInformation(){
        StockInformation a = new StockInformation(); 
        for (int i = 0 ; i < URL.size(); i ++)
            stockPrice.add(a.readPrice(tickerSym.get(i), URL.get(i)));
        System.out.println(stockPrice);
    }
    public static void main (String [] args){
        Stocks s = new Stocks(); 
        s.StockURLs();
        s.addTickers();
        s.getInformation(); 

    }
}