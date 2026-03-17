package ioprogramming.designpatterns;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Circle"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Rectangle"); }
}

class ShapeFactory {
    public static Shape getShape(String type) {
        if(type.equalsIgnoreCase("circle")) return new Circle();
        if(type.equalsIgnoreCase("rectangle")) return new Rectangle();
        return null;
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        Shape s = ShapeFactory.getShape("circle");
        s.draw();
    }
}