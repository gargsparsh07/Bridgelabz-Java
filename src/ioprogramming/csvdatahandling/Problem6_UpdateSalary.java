package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem6_UpdateSalary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated_employees.csv"));

        String line = br.readLine();
        bw.write(line + "\n");

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[2].equals("IT")) {
                double sal = Double.parseDouble(d[3]) * 1.10;
                d[3] = String.valueOf(sal);
            }
            bw.write(String.join(",", d) + "\n");
        }
        br.close();
        bw.close();
    }
}
