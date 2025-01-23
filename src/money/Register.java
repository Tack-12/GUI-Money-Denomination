package money;


public class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.0, "bill", "images/100.png"),
            new Denomination("Fifty Note", 50.0, "bill", "images/50.png"),
            new Denomination("Twenty Note", 20.0, "bill", "images/20.png"),
            new Denomination("Ten Note", 10.0, "bill", "images/10.png"),
            new Denomination("Five Note", 5.0, "bill", "images/5.png"),
            new Denomination("One Note", 1.0, "bill", "images/1.png"),
            new Denomination("Quarter", 0.25, "coin", "images/quarter.png"),
            new Denomination("Dime", 0.10, "coin", "images/dime.png"),
            new Denomination("Nickel", 0.05, "coin", "images/nickle.png"),
            new Denomination("Penny", 0.01, "coin", "images/penny.png"),
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
