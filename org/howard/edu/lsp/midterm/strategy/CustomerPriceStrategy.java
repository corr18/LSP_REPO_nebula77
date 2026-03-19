package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for customer price calculation.
 */
public interface CustomerPriceStrategy {
    /**
     * Calculates final price based on customer type.
     * @param price original price
     * @return final price after discount
     */
    double calculatePrice(double price);
}