package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Handles business logic transformations for Product objects.
 */
public class ProductTransformer {

    /**
     * Applies transformation rules to a single product:
     * - Uppercases the name
     * - Discounts Electronics by 10%
     * - Sets category to Premium Electronics if price > 500
     * - Sets price range
     *
     * @param product Product to transform
     */
    public static void transform(Product product) {

        boolean originalElectronics = product.getCategory().equals("Electronics");

        // Uppercase name
        product.setName(product.getName().toUpperCase());

        // Apply discount for Electronics
        if (originalElectronics) {
            BigDecimal discounted = product.getPrice().multiply(new BigDecimal("0.90"));
            product.setPrice(discounted);
        }

        // Round price
        BigDecimal rounded = product.getPrice().setScale(2, RoundingMode.HALF_UP);
        product.setPrice(rounded);

        // Premium Electronics rule
        if (originalElectronics && rounded.compareTo(new BigDecimal("500.00")) > 0) {
            product.setCategory("Premium Electronics");
        }

        // Set price range
        if (rounded.compareTo(new BigDecimal("10.00")) <= 0) {
            product.setPriceRange("Low");
        } else if (rounded.compareTo(new BigDecimal("100.00")) <= 0) {
            product.setPriceRange("Medium");
        } else if (rounded.compareTo(new BigDecimal("500.00")) <= 0) {
            product.setPriceRange("High");
        } else {
            product.setPriceRange("Premium");
        }
    }
}
