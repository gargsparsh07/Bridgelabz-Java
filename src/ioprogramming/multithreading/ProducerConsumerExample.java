package ioprogramming.multithreading;

import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    public synchronized void produce(int value) {
        try {
            while (queue.size() == capacity) {
                wait();
            }

            queue.add(value);
            System.out.println("Produced: " + value);

            notify();

        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }

    public synchronized void consume() {
        try {
            while (queue.isEmpty()) {
                wait();
            }

            int value = queue.poll();
            System.out.println("Consumed: " + value);

            notify();

        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
    }
}

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            resource.produce(i);
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            resource.consume();
            try { Thread.sleep(150); }
            catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}