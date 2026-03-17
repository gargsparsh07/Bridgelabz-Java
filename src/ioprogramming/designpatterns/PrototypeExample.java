package ioprogramming.designpatterns;

class Employee implements Cloneable {

    String name;

    Employee(String name){ this.name = name; }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypeExample {
    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee("Sparsh");
        Employee e2 = (Employee) e1.clone();

        System.out.println(e2.name);
    }
}