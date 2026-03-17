package ioprogramming.csvdatahandling;
import java.io.*;

public class Problem13_DBtoCSV {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw=new BufferedWriter(new FileWriter("db_employees.csv"));
        bw.write("EmployeeID,Name,Department,Salary\n");

        String[][] db={
                {"1","Aman","IT","50000"},
                {"2","Rahul","HR","45000"},
                {"3","Neha","Finance","70000"}
        };

        for(String[] e:db)
            bw.write(String.join(",",e)+"\n");

        bw.close();
    }
}
