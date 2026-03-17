package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {

    @MaxLength(5)
    String username;

    public User(String username) throws Exception {

        Field field = this.getClass().getDeclaredField("username");
        MaxLength max = field.getAnnotation(MaxLength.class);

        if (username.length() > max.value()) {
            throw new IllegalArgumentException("Username too long!");
        }

        this.username = username;
    }
}

public class MaxLengthExample {
    public static void main(String[] args) throws Exception {
        User u = new User("Sparsh"); // throws exception if >5
        System.out.println("Created user: " + u.username);
    }
}