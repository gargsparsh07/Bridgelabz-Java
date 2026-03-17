package ioprogramming.jsondata;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {

    static class Car {
        public String brand;
        public String model;
        public int year;
    }

    public static void main(String[] args) throws Exception {

        Car car = new Car();
        car.brand = "Toyota";
        car.model = "Fortuner";
        car.year = 2023;

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(car);

        System.out.println(json);
    }
}