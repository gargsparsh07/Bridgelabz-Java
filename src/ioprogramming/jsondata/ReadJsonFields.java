package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonFields {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(new File("user.json"));

        String name = node.get("name").asText();
        String email = node.get("email").asText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}