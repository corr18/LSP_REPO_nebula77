package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class using Strategy pattern to calculate price.
 */
public class PriceCalculator {

    private CustomerPriceStrategy strategy;

    /**
     * Sets the customer strategy.
     * @param strategy strategy for customer type
     */
    public void setStrategy(CustomerPriceStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the assigned strategy.
     * @param price original price
     * @return final price
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Customer strategy not set");
        }
        return strategy.calculatePrice(price);
    }
}