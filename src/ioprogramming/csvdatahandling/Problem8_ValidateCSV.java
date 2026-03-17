package ioprogramming.csvdatahandling;
import java.io.*;
import java.util.regex.Pattern;

public class Problem8_ValidateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
        br.readLine();
        String line;

        Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Pattern phone = Pattern.compile("\\d{10}");

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (!email.matcher(d[2]).matches() || !phone.matcher(d[3]).matches())
                System.out.println("Invalid Row: " + line);
        }
        br.close();
    }
}
