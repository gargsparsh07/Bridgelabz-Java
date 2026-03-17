package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem5_SearchEmployee {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        br.readLine();
        String line;

        String search = "Aman";

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[1].equalsIgnoreCase(search))
                System.out.println("Dept: " + d[2] + " Salary: " + d[3]);
        }
        br.close();
    }
}
