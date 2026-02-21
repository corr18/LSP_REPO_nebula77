package org.howard.edu.lsp.assignment3;

/**
 * Main class to run the ETL pipeline.
 */
public class ETLPipeline {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java ETLPipeline <inputCSV> <outputCSV>");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        CSVProcessor processor = new CSVProcessor();
        processor.process(inputPath, outputPath);
    }
}
