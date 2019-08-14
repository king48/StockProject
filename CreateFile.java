import java.io.*; 
import java.lang.*; 
import java.util.*; 

public class CreateFile {
    private Formatter x; 

    public void openFile (){
        try {
            x= new Formatter ("file.txt");
        }catch (Exception e){
            System.out.println("Somethings wrong"); 
        }
    }
    public void closeFile(){
        x.close (); 
    }
    public void writeToFile (){
        x.format("%s%s%s%s%s%n","TD_Bank ","TD ","72.12 ", "123,123,123 ", "https://ca.finance.yahoo.com/quote/TD.TO?p=TD.TO&.tsrc=fin-srch"); 
        x.format("%s%s%s%s%s%n","Tesla ","TSLA ","220.12 ","12,123,123 ", "https://ca.finance.yahoo.com/quote/TSLA/news?p=TSLA&.tsrc=fin-srch"); 
        x.format("%s%s%s%s%s%n","Manulife_Financial ","MFC ","22.12 ","32,125 ", "https://ca.finance.yahoo.com/quote/MFC.TO/key-statistics?p=MFC.TO"); 
        x.format("%s%s%s%s%s%n", "United_Technology ", "UTX ", "124.30 ", "107,234,587 ", "https://ca.finance.yahoo.com/quote/UTX?p=UTX&.tsrc=fin-srch");

    }
    public static void main (String [] args){
        CreateFile c = new CreateFile(); 
        c.openFile();
        c.writeToFile();
        c.closeFile();
    }
}