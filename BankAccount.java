import java.util.Scanner;

class BankAccount {
    // Data members
    private String depositorName;
    private String accountNumber;
    private String accountType;
    private double balance;

    // Member function to assign initial values
    public void assignInitialValues(String name, String accNumber, String accType, double initialBalance) {
        this.depositorName = name;
        this.accountNumber = accNumber;
        this.accountType = accType;
        this.balance = initialBalance;
    }

    // Member function to deposit an amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Member function to withdraw an amount after checking the balance
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Member function to display the name and balance
    public void displayAccountHolderInfo() {
        System.out.println("Account Holder: " + depositorName);
        System.out.println("Account Balance: " + balance);
    }

    // Main method to test the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Assign Initial Values");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Holder Name and Respective Account Balance");
            System.out.println("5. Exit");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNumber = sc.nextLine();
                    System.out.print("Enter Account Type: ");
                    String accType = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();
                    account.assignInitialValues(name, accNumber, accType, initialBalance);
                    System.out.println("Initial values assigned successfully.");
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.displayAccountHolderInfo();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
