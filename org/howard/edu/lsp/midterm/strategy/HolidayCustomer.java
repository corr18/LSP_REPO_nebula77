package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday promotion customer receives 15% discount.
 */
public class HolidayCustomer implements CustomerPriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}