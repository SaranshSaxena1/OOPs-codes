import java.util.Scanner;

public class ThreadOrderExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the three long integers from the user
        System.out.print("Enter time for Main thread in milliseconds: ");
        long x = scanner.nextLong();

        System.out.print("Enter time for T1 thread in milliseconds: ");
        long y = scanner.nextLong();

        System.out.print("Enter time for T2 thread in milliseconds: ");
        long z = scanner.nextLong();

        // Main thread task
        Runnable mainThreadTask = () -> {
            System.out.println("Main Thread: Sleeping for " + x + " milliseconds");
            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                System.err.println("Main thread interrupted");
            }
        };

        // T1 thread task
        Runnable t1Task = () -> {
            System.out.println("T1: Sleeping for " + y + " milliseconds");
            try {
                Thread.sleep(y);
            } catch (InterruptedException e) {
                System.err.println("T1 thread interrupted");
            }
        };

        // T2 thread task
        Runnable t2Task = () -> {
            System.out.println("T2: Sleeping for " + z + " milliseconds");
            try {
                Thread.sleep(z);
            } catch (InterruptedException e) {
                System.err.println("T2 thread interrupted");
            }
        };

        // Start Main thread task directly
        mainThreadTask.run();

        // Create and start T1 and T2 threads
        Thread t1 = new Thread(t1Task);
        Thread t2 = new Thread(t2Task);

        // Start T1 and wait for it to finish before starting T2
        try {
            t1.start();
            t1.join(); // Ensures T1 completes before starting T2
        } catch (InterruptedException e) {
            System.err.println("T1 join interrupted");
        }

        // Start T2 after T1 completes
        try {
            t2.start();
            t2.join(); // Ensures T2 completes before ending the program
        } catch (InterruptedException e) {
            System.err.println("T2 join interrupted");
        }

        System.out.println("All threads have completed their tasks.");
    }
}