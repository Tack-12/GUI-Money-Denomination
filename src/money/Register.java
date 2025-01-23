package money;

import java.util.Scanner;

public class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.00, "bill", "src/images/100.png"),
            new Denomination("Fifty Note", 50.00, "bill", "src/images/50.png"),
            new Denomination("Twenty Note", 20.00, "bill", "src/images/20.png"),
            new Denomination("Ten Note", 10.00, "bill", "src/images/10.png"),
            new Denomination("Five Note", 5.00, "bill", "src/images/5.png"),
            new Denomination("One Note", 1.00, "bill", "src/images/1.png"),
            new Denomination("Quarter", 0.25, "coin", "src/images/quarter.png"),
            new Denomination("Dime", 0.10, "coin", "src/images/dime.png"),
            new Denomination("Nickel", 0.05, "coin", "src/images/nickle.png"),
            new Denomination("Penny", 0.01, "coin", "src/images/penny.png"),
    };

    public Purse makeChange(double amt) {
        Purse purse = new Purse();

        // If the amount is greater than or equal to 0.005 but less than 0.01, round it up to 0.01
        if (amt >= 0.005 && amt < 0.01) {
            amt = 0.01;
        }

        // Process the denominations
        for (Denomination denom : denominations) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 1000.0) / 1000.0; // Avoid floating-point errors
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();  // Initialize the Register object
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Enter the amount of money you would like to see:");
            double amount = scanner.nextDouble();

            // Exit if the user enters 0 or a negative value
            if (amount <= 0) {
                System.out.println("Empty Purse");
            } else {
                Purse purse = register.makeChange(amount);
                System.out.println("Change for $" + String.format("%.2f", amount) + ":");
                System.out.println(purse);
            }

            // Ask if the user wants to continue
            System.out.println("\nWould you like to try another amount? (yes/no):");
            String userResponse = scanner.next().trim().toLowerCase();
            continueProgram = userResponse.equals("yes");
        }

        System.out.println("Bye, back to poor life!");
        scanner.close();
    }
}
