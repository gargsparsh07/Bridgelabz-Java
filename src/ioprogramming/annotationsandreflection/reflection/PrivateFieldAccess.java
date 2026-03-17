package ioprogramming.annotationsandreflection.reflection;

import java.lang.reflect.*;

class Person {
    private int age = 20;
}

public class PrivateFieldAccess {

    public static void main(String[] args) throws Exception {

        Person p = new Person();

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        field.set(p, 30); // modify value

        int value = (int) field.get(p);
        System.out.println("Modified Age: " + value);
    }
}