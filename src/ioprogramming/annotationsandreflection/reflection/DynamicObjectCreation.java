package ioprogramming.annotationsandreflection.reflection;

import java.lang.reflect.*;

class Student {
    String name;

    public Student() {
        name = "Default Student";
    }
}

public class DynamicObjectCreation {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("Student");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        Student s = (Student) obj;

        System.out.println("Student Name: " + s.name);
    }
}