package money;

public class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.0, "bill", "hundred.png"),
            new Denomination("Fifty Note", 50.0, "bill", "fifty.png"),
            new Denomination("Twenty Note", 20.0, "bill", "twenty.png"),
            new Denomination("Ten Note", 10.0, "bill", "ten.png"),
            new Denomination("Five Note", 5.0, "bill", "five.png"),
            new Denomination("One Note", 1.0, "bill", "one.png"),
            new Denomination("Quarter", 0.25, "coin", "quarter.png"),
            new Denomination("Dime", 0.10, "coin", "dime.png"),
            new Denomination("Nickel", 0.05, "coin", "nickel.png"),
            new Denomination("Penny", 0.01, "coin", "penny.png"),
    };

    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (Denomination denom : denominations) {
            int count = (int) (amt / denom.amt());
            if (count > 0) {
                purse.add(denom, count);
                amt -= count * denom.amt();
                amt = Math.round(amt * 100.0) / 100.0; // Avoid floating-point errors
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Purse purse = register.makeChange(287.38);
        System.out.println(purse);
    }
}
