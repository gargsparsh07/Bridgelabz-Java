package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Rahul");

        ObjectNode json2 = mapper.createObjectNode();
        json2.put("age", 25);

        json1.setAll(json2);

        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json1));
    }
}