package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;

/**
 * Reads products from a CSV file, applies transformations, writes to an output CSV.
 * Tracks statistics for rows read, transformed, skipped.
 */
public class CSVProcessor {

    private int rowsRead = 0;
    private int rowsTransformed = 0;
    private int rowsSkipped = 0;

    /**
     * Process a CSV file: read, transform, write.
     * @param inputPath  Path to input CSV
     * @param outputPath Path to output CSV
     */
    public void process(String inputPath, String outputPath) {

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + inputPath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            reader.readLine(); // skip header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line;

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");

                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    Product product = new Product(id, name, price, category);

                    ProductTransformer.transform(product);

                    writer.write(product.toCSV());
                    writer.newLine();

                    rowsTransformed++;

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        printSummary(outputPath);
    }

    private void printSummary(String outputPath) {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file written to: " + outputPath);
    }
}
