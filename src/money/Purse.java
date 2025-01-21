package money;

import java.util.HashMap;
import java.util.Map;




public class Purse {

    Map<Denomination,Integer> cash = new HashMap<>();

   public void add(Denomination type, int amount)
   {
       cash.put(type, cash.getOrDefault(type,0) + amount);

   }

   public void remove(Denomination type , int amount){

       cash.put(type, cash.getOrDefault(type,0) - amount);
   }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Purse contents:\n");
        for (var entry : cash.entrySet()) {
            sb.append(entry.getKey().name())
                    .append(" (" + entry.getKey().form() + "): ")
                    .append(entry.getValue())
                    .append("\n");
        }
        sb.append("Total value: $").append(String.format("%.2f", getValue()));
        return sb.toString();
    }
}


