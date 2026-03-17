package ioprogramming.annotationsandreflection.reflection;

import java.lang.reflect.*;

public class ClassInspector {

    public static void main(String[] args) throws Exception {

        String className = "java.util.ArrayList"; // you can change this

        Class<?> clazz = Class.forName(className);

        System.out.println("Class Name: " + clazz.getName());

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}