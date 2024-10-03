package org.example;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<String, Integer> prices = new HashMap<>();
    private Map<String, SpecialPriceRules> specialPrices = new HashMap<>();
    private Map<String, Integer> itemCounts = new HashMap<>();
    private int total = 0;

    public Checkout() {
        //hardcoded values for green phase of TDD
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);

        //hardcoded values for green phase of TDD, to test special price requirement
        specialPrices.put("A", new SpecialPriceRules(3, 150));
        specialPrices.put("B", new SpecialPriceRules(2, 45));
    }

    public void scan (String item){
        if (prices.containsKey(item)) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
            applyPrice(item);
        }
    }

    public void applyPrice(String item){
        int count = itemCounts.get(item);
        if (specialPrices.containsKey(item)) {
            SpecialPriceRules rules = specialPrices.get(item);
            if (count % rules.getQuantity() == 0) {
                total -= (rules.getQuantity() - 1) * prices.get(item);  // Adjust for special price
                total += rules.getPrice();
            } else {
                total += prices.get(item);
            }
        } else {
            total += prices.get(item);
        }
    }

    public int getTotal() {
        return total;
    }
}
