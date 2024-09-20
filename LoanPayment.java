import java.util.Scanner;

public class LoanPayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter loan amount: ");
        double loanAmount = sc.nextDouble();
        
        System.out.print("Enter annual interest rate (in percentage): ");
        double annualInterestRate = sc.nextDouble();
        
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();
        
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int totalMonths = years * 12;

        double monthlyPayment = (loanAmount * monthlyInterestRate) / 
                (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));

        System.out.printf("Monthly payment: %.2f\n", monthlyPayment);
    }
}
