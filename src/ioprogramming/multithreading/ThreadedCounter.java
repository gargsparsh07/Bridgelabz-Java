package ioprogramming.multithreading;

import java.util.Scanner;

class Counter {
    private int count = 1;
    private int limit;

    public Counter(int limit) {
        this.limit = limit;
    }

    public synchronized void printCount(String threadName) {
        while (count <= limit) {
            System.out.println(threadName + " : " + count);
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        counter.printCount(Thread.currentThread().getName());
    }
}

public class ThreadedCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter counting limit: ");
            int limit = sc.nextInt();

            if (limit <= 0) {
                throw new IllegalArgumentException("Limit must be positive.");
            }

            Counter counter = new Counter(limit);

            Thread t1 = new CounterThread(counter, "Thread-1");
            Thread t2 = new CounterThread(counter, "Thread-2");
            Thread t3 = new CounterThread(counter, "Thread-3");

            t1.start();
            t2.start();
            t3.start();

        } catch (Exception e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }
    }
}