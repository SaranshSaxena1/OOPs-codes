// Abstract base class Shape
abstract class Shape {
    // Abstract method to calculate the area
    public abstract double getArea();

    // Abstract method to calculate the volume (default to 0 for 2D shapes)
    public abstract double getVolume();
}

// TwoDimensionalShape class (inherits from Shape)
abstract class TwoDimensionalShape extends Shape {
    // 2D shapes don't have volume, so return 0
    @Override
    public double getVolume() {
        return 0;
    }
}

// ThreeDimensionalShape class (inherits from Shape)
abstract class ThreeDimensionalShape extends Shape {
    // 3D shapes must implement both getArea and getVolume
}

// Circle class (inherits from TwoDimensionalShape)
class Circle extends TwoDimensionalShape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Calculate the area of the circle
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Description
    public String toString() {
        return "Circle with radius " + radius;
    }
}

// Square class (inherits from TwoDimensionalShape)
class Square extends TwoDimensionalShape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Calculate the area of the square
    @Override
    public double getArea() {
        return side * side;
    }

    // Description
    public String toString() {
        return "Square with side " + side;
    }
}

// Sphere class (inherits from ThreeDimensionalShape)
class Sphere extends ThreeDimensionalShape {
    private double radius;

    // Constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Calculate the surface area of the sphere
    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    // Calculate the volume of the sphere
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Description
    public String toString() {
        return "Sphere with radius " + radius;
    }
}

// Cube class (inherits from ThreeDimensionalShape)
class Cube extends ThreeDimensionalShape {
    private double side;

    // Constructor
    public Cube(double side) {
        this.side = side;
    }

    // Calculate the surface area of the cube
    @Override
    public double getArea() {
        return 6 * side * side;
    }

    // Calculate the volume of the cube
    @Override
    public double getVolume() {
        return side * side * side;
    }

    // Description
    public String toString() {
        return "Cube with side " + side;
    }
}

// Main class to test the Shape hierarchy
public class ShapeTest {
    public static void main(String[] args) {
        // Create an array of Shape references
        Shape[] shapes = new Shape[4];

        // Initialize the array with various shapes
        shapes[0] = new Circle(3.0);
        shapes[1] = new Square(4.0);
        shapes[2] = new Sphere(5.0);
        shapes[3] = new Cube(2.5);

        // Loop through the array and display the area and volume
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.getArea());
            // If it's a 3D shape, display the volume
            if (shape instanceof ThreeDimensionalShape) {
                System.out.println("Volume: " + shape.getVolume());
            }
            System.out.println();
        }
    }
}
