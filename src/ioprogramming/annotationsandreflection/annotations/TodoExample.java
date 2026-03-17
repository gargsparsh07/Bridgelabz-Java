package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Feature {

    @Todo(task="Add Login", assignedTo="Sparsh")
    public void loginFeature() {}

    @Todo(task="Fix Bug", assignedTo="Rahul", priority="HIGH")
    public void fixBug() {}
}

public class TodoExample {
    public static void main(String[] args) {

        for (Method m : Feature.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Task: " + t.task());
                System.out.println("Assigned To: " + t.assignedTo());
                System.out.println("Priority: " + t.priority());
                System.out.println();
            }
        }
    }
}