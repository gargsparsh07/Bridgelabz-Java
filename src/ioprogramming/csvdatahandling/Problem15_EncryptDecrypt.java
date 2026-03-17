package ioprogramming.csvdatahandling;
import java.io.*;
import java.util.Base64;

public class Problem15_EncryptDecrypt {
    public static void main(String[] args) throws Exception {

        // Encrypt
        BufferedReader br=new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("encrypted.csv"));
        bw.write(br.readLine()+"\n");
        String line;

        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            d[3]=Base64.getEncoder().encodeToString(d[3].getBytes());
            bw.write(String.join(",",d)+"\n");
        }
        br.close(); bw.close();

        // Decrypt
        BufferedReader br2=new BufferedReader(new FileReader("encrypted.csv"));
        br2.readLine();

        while((line=br2.readLine())!=null){
            String[] d=line.split(",");
            String salary=new String(Base64.getDecoder().decode(d[3]));
            System.out.println(d[0]+" "+d[1]+" "+salary);
        }
        br2.close();
    }
}
