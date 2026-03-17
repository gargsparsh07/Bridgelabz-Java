package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem3_CountRows {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();
        int count = 0;

        while (br.readLine() != null) count++;

        System.out.println("Total Records: " + count);
        br.close();
    }
}
