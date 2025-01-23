package money;

public class Register {
    private final Denomination[] denominations = {
            new Denomination("Hundred Note", 100.0, "bill", "Images/100.jpg"),
            new Denomination("Fifty Note", 50.0, "bill", "Images/50.jpg"),
            new Denomination("Twenty Note", 20.0, "bill", "Images/20.jpg"),
            new Denomination("Ten Note", 10.0, "bill", "Images/10.jpg"),
            new Denomination("Five Note", 5.0, "bill", "Images/5.jpg"),
            new Denomination("One Note", 1.0, "bill", "Images/1.jpg"),
            new Denomination("Quarter", 0.25, "coin", "Images/quarter.jpg"),
            new Denomination("Dime", 0.10, "coin", "Images/dime.jpg"),
            new Denomination("Nickel", 0.05, "coin", "Images/nickel.jpg"),
            new Denomination("Penny", 0.01, "coin", "Images/penny.jpg"),
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
