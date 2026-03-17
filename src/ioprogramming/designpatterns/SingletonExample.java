package ioprogramming.designpatterns;

class Logger {

    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        System.out.println("Log: " + msg);
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("First Message");
        System.out.println(l1 == l2); // true
    }
}