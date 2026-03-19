package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP customer receives 20% discount.
 */
public class VIPCustomer implements CustomerPriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.8;
    }
}