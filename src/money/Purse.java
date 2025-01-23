package money;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(Denomination type, int num) {
        if (!cash.containsKey(type) || cash.get(type) < num) {
            throw new IllegalArgumentException("Not enough of the denomination to remove.");
        }
        cash.put(type, cash.get(type) - num);
        if (cash.get(type) == 0) {
            cash.remove(type);
        }
        return type.amt() * num;
    }

    public double getValue() {
        return cash.entrySet().stream().mapToDouble(e -> e.getKey().amt() * e.getValue()).sum();
    }

    // Getter for the cash map
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        for (var entry : cash.entrySet()) {
            sb.append(entry.getKey().name())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
