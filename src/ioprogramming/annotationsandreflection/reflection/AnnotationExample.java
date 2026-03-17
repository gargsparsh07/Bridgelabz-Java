package ioprogramming.annotationsandreflection.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Sparsh")
class MyClass {
}

public class AnnotationExample {

    public static void main(String[] args) {

        Author author = MyClass.class.getAnnotation(Author.class);

        if (author != null) {
            System.out.println("Author Name: " + author.name());
        }
    }
}