import java.util.Scanner;

public class AirlineReservationSystem {
    // Array to represent the seating chart (false means the seat is available)
    private static boolean[] seats = new boolean[10];

    // Method to assign a seat in first class (seats 1-5)
    private static void assignFirstClass() {
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {  // If the seat is available
                seats[i] = true;
                System.out.println("Boarding pass: Seat " + (i + 1) + " (First Class)");
                return;
            }
        }
        System.out.println("First Class is full.");
    }

    // Method to assign a seat in economy class (seats 6-10)
    private static void assignEconomy() {
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {  // If the seat is available
                seats[i] = true;
                System.out.println("Boarding pass: Seat " + (i + 1) + " (Economy)");
                return;
            }
        }
        System.out.println("Economy is full.");
    }

    // Method to check if all seats are full
    private static boolean isFull() {
        for (boolean seat : seats) {
            if (!seat) {
                return false;
            }
        }
        return true;
    }

    // Main method to run the airline reservation system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Continue until all seats are full
        while (!isFull()) {
            System.out.println("Please type 1 for First Class or 2 for Economy:");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Try to assign a seat in first class
                assignFirstClass();
                // If full, ask if economy seat is acceptable
                if (seats[0] && seats[1] && seats[2] && seats[3] && seats[4]) {
                    System.out.println("Would you like to be placed in Economy? (yes/no)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        assignEconomy();
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else if (choice == 2) {
                // Try to assign a seat in economy class
                assignEconomy();
                // If full, ask if first class seat is acceptable
                if (seats[5] && seats[6] && seats[7] && seats[8] && seats[9]) {
                    System.out.println("Would you like to be placed in First Class? (yes/no)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        assignFirstClass();
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else {
                System.out.println("Invalid choice. Please enter 1 for First Class or 2 for Economy.");
            }
        }

        System.out.println("All seats are full. Thank you for using our airline reservation system.");
        scanner.close();
    }
}
