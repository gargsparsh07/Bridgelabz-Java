package ioprogramming.annotationsandreflection.reflection;

import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello World");
    }
}

public class LoggingProxyExample {

    public static void main(String[] args) {

        Greeting original = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                (proxyObj, method, methodArgs) -> {
                    System.out.println("Method called: " + method.getName());
                    return method.invoke(original, methodArgs);
                }
        );

        proxy.sayHello();
    }
}