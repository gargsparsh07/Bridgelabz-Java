package ioprogramming.csvdatahandling;
import java.io.*;
import java.util.*;

public class Problem12_Duplicates {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("students.csv"));
        br.readLine();

        Set<String> set=new HashSet<>();
        String line;

        while((line=br.readLine())!=null){
            String id=line.split(",")[0];
            if(!set.add(id))
                System.out.println("Duplicate: "+line);
        }
        br.close();
    }
}
