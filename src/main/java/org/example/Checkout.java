package org.example;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<String, Integer> prices = new HashMap<>();
    private int total = 0;

    public Checkout() {
        //hardcoded values for green phase of TDD
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
    }

    public void scan (String item){
        if (prices.containsKey(item)) {
            total += prices.get(item);
        }
    }

    public int getTotal() {
        return total;
    }
}
