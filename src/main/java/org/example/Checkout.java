package org.example;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<String, Integer> prices = new HashMap<>();
    private Map<String, Integer> specialPrices = new HashMap<>();
    private Map<String, Integer> itemCounts = new HashMap<>();
    private int total = 0;

    public Checkout() {
        //hardcoded values for green phase of TDD
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);

        //hardcoded values for green phase of TDD, to test special price requirement
        specialPrices.put("A", 130);
    }

    public void scan (String item){
        if (prices.containsKey(item)) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
            applyPrice(item);
        }
    }

    public void applyPrice(String item){
        int count = itemCounts.get(item);
        if (item.equals("A") && count % 3 == 0) {
            total -= 2 * prices.get(item);
            total += prices.get(item);
        } else {
            total += prices.get(item);
        }
    }

    public int getTotal() {
        return total;
    }
}
