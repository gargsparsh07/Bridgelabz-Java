package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentJsonExample {

    static class Student {
        public String name;
        public int age;
        public String[] subjects;
    }

    public static void main(String[] args) throws Exception {

        Student student = new Student();
        student.name = "Rahul";
        student.age = 21;
        student.subjects = new String[]{"Math", "Physics", "Computer"};

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(student);

        System.out.println(json);
    }
}