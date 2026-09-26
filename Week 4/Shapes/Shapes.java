import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

abstract class Shape implements Comparable<Shape> {

    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double area();

    public abstract double perimeter();

    @Override
    public String toString() {
        return "Area: " + area() + "\n" +
                "Petimeter: " + perimeter();
    }

    @Override
    public int compareTo(Shape o) {
        if (this.area() > o.area()) {
            return 1;
        }
        if (this.area() < o.area()) {
            return -1;
        }
        return 0;
    }
}

class Circle extends Shape {

    protected int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * radius);
    }
}

class Rectangle extends Shape {

    protected double width;
    protected double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return (width * height);
    }

    @Override
    public double perimeter() {
        return ((2 * height) + (2 * width));
    }
}

class Triangle extends Shape {

    protected double sideA;
    protected double sideB;
    protected double sideC;

    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt((s * (s - sideA)) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return (sideA + sideB + sideC);
    }
}

class TaxableRectangle extends Rectangle implements Taxable {

    protected double taxRate;

    public TaxableRectangle(String color, double width, double height, double taxRate) {
        super(color, width, height);
        this.taxRate = taxRate;
    }

    public double getTax() {
        return (taxRate * super.area());
    }

}

interface Taxable {

    public double getTax();

}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Circle("Blue", 10));
        shapes.add(new Rectangle("Red", 8, 5));
        shapes.add(new Triangle("Green", 3, 4, 6));
        shapes.add(new TaxableRectangle("Orange", 10, 12, 1.22));

        System.out.println("Before sorting: ");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        System.out.println("--------------------------");

        Collections.sort(shapes);

        System.out.println("After sorting: ");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        System.out.println("--------------------------");

        Collections.sort(shapes);

        System.out.println("Sorting by perimeter: ");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        System.out.println("--------------------------");

        System.out.println("Taxable Rectangle Test: ");
        for (Shape shape : shapes) {
            if (shape instanceof TaxableRectangle taxableRect) {
                System.out.println(taxableRect.getTax());
            }
        }
    }
}
