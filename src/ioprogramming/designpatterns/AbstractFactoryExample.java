package ioprogramming.designpatterns;

interface Car { void type(); }
interface Bike { void type(); }

class Sedan implements Car { public void type(){System.out.println("Sedan");}}
class SUV implements Car { public void type(){System.out.println("SUV");}}

class SportsBike implements Bike { public void type(){System.out.println("Sports Bike");}}
class NormalBike implements Bike { public void type(){System.out.println("Normal Bike");}}

interface VehicleFactory {
    Car createCar();
    Bike createBike();
}

class CarFactory implements VehicleFactory {
    public Car createCar(){ return new Sedan(); }
    public Bike createBike(){ return null; }
}

class BikeFactory implements VehicleFactory {
    public Car createCar(){ return null; }
    public Bike createBike(){ return new SportsBike(); }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory();
        factory.createCar().type();
    }
}