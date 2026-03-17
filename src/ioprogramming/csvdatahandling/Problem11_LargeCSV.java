package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem11_LargeCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("large.csv"));
        br.readLine();

        int count=0,batch=0;
        while(br.readLine()!=null){
            count++; batch++;
            if(batch==100){
                System.out.println("Processed: "+count);
                batch=0;
            }
        }
        br.close();
    }
}
