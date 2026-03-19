package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver program to demonstrate Strategy Pattern implementation.
 */
public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        // REGULAR
        calculator.setStrategy(new RegularCustomer());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // MEMBER
        calculator.setStrategy(new MemberCustomer());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP
        calculator.setStrategy(new VIPCustomer());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // HOLIDAY
        calculator.setStrategy(new HolidayCustomer());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}