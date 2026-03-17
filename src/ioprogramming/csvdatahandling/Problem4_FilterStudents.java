package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem4_FilterStudents {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (Integer.parseInt(d[3]) > 80)
                System.out.println(line);
        }
        br.close();
    }
}
