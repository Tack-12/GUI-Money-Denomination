package money;

import java.util.Scanner;

public class Register {
    // Denomination with all the currency and their pic
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.00, "bill", "100"),
            new Denomination("Fifty Note", 50.00, "bill", "50"),
            new Denomination("Twenty Note", 20.00, "bill", "20"),
            new Denomination("Ten Note", 10.00, "bill", "10"),
            new Denomination("Five Note", 5.00, "bill", "5"),
            new Denomination("One Note", 1.00, "bill", "1"),
            new Denomination("Quarter", 0.25, "coin", "quarter"),
            new Denomination("Dime", 0.10, "coin", "dime"),
            new Denomination("Nickel", 0.05, "coin", "nickle"),
            new Denomination("Penny", 0.01, "coin", "penny"),
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
        //console version of code
        Register register = new Register();  // Initialize the Register object
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {   //Continue until user wants to quit
            System.out.println("Enter the amount of money you would like to see:");
            double amount = scanner.nextDouble();

            // Displays empty purse if the user enters 0 or a negative value
            if (amount < 0.005) {
                System.out.println("Empty Purse");
            } else {
                Purse purse = register.makeChange(amount);
                System.out.println("Change for $" + String.format("%.2f", amount) + ":");
                System.out.println(purse);
            }

            // Ask if the user wants to continue
            System.out.println("\nWould you like to try run the money change again? (y/n):");
            String userResponse = scanner.next().trim().toLowerCase();
            continueProgram = userResponse.equals("y");
        }

        //exits code with a message
        System.out.println("You chose to exit! Thank you for using Money Denomination!");
        scanner.close();
    }
}
