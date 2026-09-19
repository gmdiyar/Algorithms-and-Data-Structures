import java.time.LocalDate;

class GeometricObject {

    protected String color;
    protected boolean filled;
    protected LocalDate dateCreated;

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = LocalDate.now();
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return "Date created: " + dateCreated +
                " Color: " + color +
                " Filled: " + filled;
    }
}

class Triangle extends GeometricObject {

    protected String color;
    protected boolean filled;
    protected float sideA;
    protected float sideB;
    protected float sideC;

    public Triangle(String color, boolean filled, float sideA, float sideB, float sideC) {
        super(color, filled);
        this.color = color;
        this.filled = filled;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        float s = sideA + sideB + sideC;
        return Math.sqrt((s * (s - sideA)) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Side A: " + sideA +
                " Side B: " + sideB +
                " Side C: " + sideC;
    }

}

public class Geometry {
    public static void main(String[] args) {
        GeometricObject object = new GeometricObject("Green", true);
        Triangle triangle = new Triangle("Red", false, 3, 5, 4);

        System.out.println(object.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println(triangle.toString());

    }
}
