package ioprogramming.annotationsandreflection.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service Called");
    }
}

class Client {

    @Inject
    private Service service;
}

public class SimpleDI {

    public static void main(String[] args) throws Exception {

        Client client = new Client();

        for (Field field : Client.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(client, field.getType().getDeclaredConstructor().newInstance());
            }
        }

        Field field = Client.class.getDeclaredField("service");
        field.setAccessible(true);
        Service service = (Service) field.get(client);
        service.serve();
    }
}