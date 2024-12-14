public class ObjectCounter {
    
    private static int count = 0;

    
    public ObjectCounter() {
        count++;
    }

    
    public static void show_count() {
        System.out.println("Number of objects created: " + count);
    }

    public static void main(String[] args) {
        ObjectCounter obj1 = new ObjectCounter();
        ObjectCounter obj2 = new ObjectCounter();
        ObjectCounter obj3 = new ObjectCounter();

        ObjectCounter.show_count(); 
    }
}
