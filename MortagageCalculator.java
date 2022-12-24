import java.util.Scanner;

public class MortagageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the loan amount
        System.out.print("Enter the loan amount: ");
        double loanAmount = scanner.nextDouble();

        // Prompt the user for the interest rate
        System.out.print("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        // Prompt the user for the loan term (in years)
        System.out.print("Enter the loan term (in years): ");
        int loanTerm = scanner.nextInt();

        // Calculate the monthly interest rate
        double monthlyInterestRate = interestRate / 12.0 / 100.0;

        // Calculate the number of monthly payments
        int numberOfPayments = loanTerm * 12;

        // Calculate the monthly payment
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        // Print the monthly payment
        System.out.println("Your monthly payment is: $" + monthlyPayment);
    }
}
