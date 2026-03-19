package org.howard.edu.lsp.midterm.strategy;

/**
 * Member customer receives 10% discount.
 */
public class MemberCustomer implements CustomerPriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.9;
    }
}