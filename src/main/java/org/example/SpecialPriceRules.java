package org.example;

public class SpecialPriceRules {
    private int quantity;
    private int price;

    public SpecialPriceRules(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
