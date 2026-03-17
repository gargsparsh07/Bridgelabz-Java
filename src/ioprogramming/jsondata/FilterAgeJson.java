package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterAgeJson {

    public static void main(String[] args) throws Exception {

        String json = "[{\"name\":\"Rahul\",\"age\":28},{\"name\":\"Amit\",\"age\":22}]";

        ObjectMapper mapper = new ObjectMapper();

        JsonNode users = mapper.readTree(json);

        for (JsonNode user : users) {

            if (user.get("age").asInt() > 25) {

                System.out.println(user.get("name").asText());
            }
        }
    }
}