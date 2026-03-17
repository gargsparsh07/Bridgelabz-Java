package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem2_WriteCSV {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("ID,Name,Department,Salary\n");
        bw.write("1,Aman,IT,50000\n");
        bw.write("2,Rahul,HR,40000\n");
        bw.write("3,Neha,Finance,60000\n");
        bw.write("4,Sneha,IT,70000\n");
        bw.write("5,Rohit,Sales,45000\n");
        bw.close();
    }
}
