package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular customer pays full price.
 */
public class RegularCustomer implements CustomerPriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}