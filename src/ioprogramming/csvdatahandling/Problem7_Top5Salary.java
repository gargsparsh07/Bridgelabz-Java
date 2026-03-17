package ioprogramming.csvdatahandling;
import java.io.*;
import java.util.*;

public class Problem7_Top5Salary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        br.readLine();

        List<String[]> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null)
            list.add(line.split(","));

        list.sort((a,b)->Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        for(int i=0;i<Math.min(5,list.size());i++)
            System.out.println(Arrays.toString(list.get(i)));

        br.close();
    }
}
