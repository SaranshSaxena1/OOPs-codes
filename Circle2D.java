public class Circle2D {
    
    private double x;
    private double y;
    private double radius;

    
    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    
    public double getArea() {
        return Math.PI * radius * radius;
    }

    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    
    public boolean contains(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= this.radius;
    }

    
    public boolean contains(Circle2D circle) {
        double distance = Math.sqrt(Math.pow(circle.x - this.x, 2) + Math.pow(circle.y - this.y, 2));
        return distance + circle.radius <= this.radius;
    }

    
    public boolean overlaps(Circle2D circle) {
        double distance = Math.sqrt(Math.pow(circle.x - this.x, 2) + Math.pow(circle.y - this.y, 2));
        return distance < this.radius + circle.radius && distance > Math.abs(this.radius - circle.radius);
    }

    
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        
        System.out.println("c1 contains point (3, 3): " + c1.contains(3, 3));

        
        Circle2D c2 = new Circle2D(4, 5, 10.5);
        System.out.println("c1 contains c2: " + c1.contains(c2));


        Circle2D c3 = new Circle2D(3, 5, 2.3);
        System.out.println("c1 overlaps with c3: " + c1.overlaps(c3));
    }
}
