package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Case C: Missing input file
        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            // Read header
            reader.readLine(); // Skip header

            // Always write output header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line;

            while ((line = reader.readLine()) != null) {

                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");

                // Must contain exactly 4 fields
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    // Trim whitespace
                    String productIdStr = fields[0].trim();
                    String name = fields[1].trim();
                    String priceStr = fields[2].trim();
                    String category = fields[3].trim();

                    // Parse ProductID
                    int productId = Integer.parseInt(productIdStr);

                    // Parse Price
                    BigDecimal price = new BigDecimal(priceStr);

                    // TRANSFORMATIONS (in exact order)

                    // 1. Uppercase name
                    name = name.toUpperCase();

                    // 2. If Electronics → apply 10% discount
                    boolean originalElectronics = category.equals("Electronics");

                    if (originalElectronics) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // 3. Round price (round-half-up to 2 decimals)
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // 4. Premium Electronics rule
                    if (originalElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    // 5. Determine PriceRange
                    String priceRange;

                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // Write transformed row
                    writer.write(productId + "," + name + "," + price.toString() + "," + category + "," + priceRange);
                    writer.newLine();

                    rowsTransformed++;

                } catch (Exception e) {
                    // If parsing fails
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        // Print run summary
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file written to: " + outputPath);
    }
}




