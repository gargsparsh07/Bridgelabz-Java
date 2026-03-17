package ioprogramming.csvdatahandling;
import java.io.*;
import java.util.*;

class Student {
    int id; String name; int age; int marks;

    Student(int id,String name,int age,int marks){
        this.id=id;this.name=name;this.age=age;this.marks=marks;
    }

    public String toString(){
        return id+" "+name+" "+age+" "+marks;
    }
}

public class Problem9_CSVtoObjects {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();
        List<Student> list=new ArrayList<>();
        String line;

        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            list.add(new Student(Integer.parseInt(d[0]),d[1],Integer.parseInt(d[2]),Integer.parseInt(d[3])));
        }

        list.forEach(System.out::println);
        br.close();
    }
}
