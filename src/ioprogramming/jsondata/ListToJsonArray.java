package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ListToJsonArray {

    static class User {
        public String name;
        public int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {

        List<User> users = new ArrayList<>();

        users.add(new User("Rahul", 28));
        users.add(new User("Amit", 30));

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(users);

        System.out.println(json);
    }
}