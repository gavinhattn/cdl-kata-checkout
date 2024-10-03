package org.example;

import java.util.Scanner;

public class CheckoutApp {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Checkout System");
        System.out.println("Please scan items (enter 'done' to finish):");

        while (true) {
            System.out.print("Scan item (A, B, C, D, E, F, etc.): ");
            input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("DONE")) {
                break; // Exit the loop when the user is done
            }

            checkout.scan(input); // Scan the input item

            // Print the running total
            System.out.println("Running Total: " + checkout.getTotal() + " pence");
        }

        System.out.println("Total Cost: " + checkout.getTotal() + " pence");
        scanner.close();
    }
}