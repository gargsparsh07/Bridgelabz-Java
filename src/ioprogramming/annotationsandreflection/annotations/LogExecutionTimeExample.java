package ioprogramming.annotationsandreflection.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class Worker {

    @LogExecutionTime
    public void slowTask() {
        for(int i=0;i<1000000;i++);
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {

        Worker worker = new Worker();

        for (Method m : Worker.class.getDeclaredMethods()) {

            if (m.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                m.invoke(worker);
                long end = System.nanoTime();

                System.out.println(m.getName() + " took: " + (end - start) + " ns");
            }
        }
    }
}