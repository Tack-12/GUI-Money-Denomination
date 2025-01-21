package money;

import money.Denomination;
import money.Purse;

import java.util.Scanner;

public class Register {

    private static final Denomination[] denominations = {
            new Denomination("Twenty Dollar Bill", 20.0, "bill", "twenty.jpg"),
            new Denomination("Ten Dollar Bill", 10.0, "bill", "ten.jpg"),
            new Denomination("Five Dollar Bill", 5.0, "bill", "five.jpg"),
            new Denomination("One Dollar Bill", 1.0, "bill", "one.jpg"),
            new Denomination("Quarter", 0.25, "coin", "quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "penny.jpg")
    };


public Purse makeChange(double amt) {
    Purse purse = new Purse();
    for (Denomination denom : Register.denominations) {
        int count = (int) (amt / denom.amt());
        if (count > 0) {
            purse.add(denom, count);
            amt -= count * denom.amt();
        }
        amt = Math.round(amt * 100.0) / 100.0; // Avoid precision issues
    }
    return purse;
}

public void main(String[] args) {
    Register Register = new Register();
    System.out.println("Enter the amount of money you would like to see:");
    Scanner scanner = new Scanner(System.in);
    Double amount = scanner.nextDouble();
    Purse purse = Register.makeChange(amount);
    System.out.println("Change for $" + amount + ":");
    System.out.println(purse);
}
}
