package ioprogramming.annotationsandreflection.reflection;

import java.lang.reflect.*;

class Product {
    String name = "Laptop";
    int price = 50000;
}

public class JsonGenerator {

    public static void main(String[] args) throws Exception {

        Product product = new Product();

        StringBuilder json = new StringBuilder("{");

        Field[] fields = product.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            json.append("\"")
                    .append(fields[i].getName())
                    .append("\":\"")
                    .append(fields[i].get(product))
                    .append("\"");

            if (i < fields.length - 1)
                json.append(",");
        }

        json.append("}");

        System.out.println(json);
    }
}