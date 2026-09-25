import java.time.LocalDate;

abstract class GeometricObjectAbstract {

    protected String color;
    protected boolean filled;
    protected LocalDate dateCreated;

    GeometricObjectAbstract(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = LocalDate.now();
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Date created: " + dateCreated + "\n" +
                " Color: " + color + "\n" +
                " Filled: " + filled + "\n";
    }
}

class TriangleNew extends GeometricObjectAbstract {

    protected float sideA;
    protected float sideB;
    protected float sideC;

    public TriangleNew(String color, boolean filled, float sideA, float sideB, float sideC) {
        super(color, filled);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        float s = (sideA + sideB + sideC) / 2;
        return Math.sqrt((s * (s - sideA)) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Side A: " + sideA + "\n" +
                " Side B: " + sideB + "\n" +
                " Side C: " + sideC + "\n";
    }

}

public class AbstractGeometry {
    public static void main(String[] args) {
        TriangleNew triangle = new TriangleNew("Red", false, 3, 5, 4);

        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println(triangle.toString());

        // The error that would occur if the GeometricObjectAbstract was to be
        // instantiated would be "GeometricObjectAbstract is abstract; cannot be
        // instantiated". This is because in order for a class to hold an abstract
        // method, the class itself has to be declared as abstract, and abstract classes
        // cannot be instantiated in Java. Fundamentally, this is because abstract
        // classes are incomplete by design choice. This is to allow for a form of
        // generic programming where the implementation of an abstract method in an
        // abstract class can be custom made for a specific subclass.
    }
}
