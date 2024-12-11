public class Triangle {
    // Data fields for the sides of the triangle
    private double side1;
    private double side2;
    private double side3;

    // No-arg constructor initializing sides to default values of 1
    public Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }

    // Constructor that accepts specified values for the sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getter and setter methods for the sides
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // Method to calculate the area of the triangle using Heron's formula
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;  // Semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Method to calculate the perimeter of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Main method to test the Triangle class
    public static void main(String[] args) {
        // Create two Triangle objects
        Triangle triangle1 = new Triangle(4, 5, 6);
        Triangle triangle2 = new Triangle(1.5, 2.5, 3.5);

        // Display properties and results for triangle1
        System.out.println("Triangle 1:");
        System.out.println("Sides: " + triangle1.getSide1() + ", " + triangle1.getSide2() + ", " + triangle1.getSide3());
        System.out.println("Area: " + triangle1.getArea());
        System.out.println("Perimeter: " + triangle1.getPerimeter());

        // Display properties and results for triangle2
        System.out.println("Triangle 2:");
        System.out.println("Sides: " + triangle2.getSide1() + ", " + triangle2.getSide2() + ", " + triangle2.getSide3());
        System.out.println("Area: " + triangle2.getArea());
        System.out.println("Perimeter: " + triangle2.getPerimeter());
    }
}
