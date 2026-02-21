# AI Transcript for Assignment 3

This document records prompts I used with a generative AI assistant to redesign my ETL pipeline for Assignment 3.

---

### **Prompt 1**
**Question:**  
"I have an ETL pipeline in Java that reads products from a CSV, transforms them, and writes output. I want to make it more object-oriented for Assignment 3. Can you suggest a class design with responsibilities?"

**AI Response (excerpt):**  
- Create a `Product` class for the product entity.  
- Create a `ProductTransformer` class to handle transformations.  
- Create a `CSVProcessor` class for reading/writing CSV files and tracking statistics.  
- Keep `ETLPipeline` as the main orchestrator.  
- Each class should have clear responsibilities and encapsulated data.  

---

### **Prompt 2**
**Question:**  
"How should I implement ProductTransformer to handle discount rules and price ranges?"

**AI Response (excerpt):**  
- Use a static `transform(Product product)` method.  
- Uppercase the product name.  
- Apply 10% discount for Electronics.  
- Set Premium Electronics for products > $500 after discount.  
- Assign `PriceRange` field based on the rounded price.  

---

### **Prompt 3**
**Question:**  
"I want CSVProcessor to handle both reading and writing CSV files and keep counts of rows read, transformed, and skipped. How should I structure the methods?"

**AI Response (excerpt):**  
- Make `process(String inputPath, String outputPath)` a public method.  
- Keep counters as private fields: `rowsRead`, `rowsTransformed`, `rowsSkipped`.  
- Use BufferedReader to read input, BufferedWriter to write output.  
- Skip invalid or empty rows, increment skipped counter.  
- Call `ProductTransformer.transform()` for each product.  

---

### **Prompt 4**
**Question:**  
"How do I update ETLPipeline to use CSVProcessor instead of separate ProductReader/ProductWriter classes?"

**AI Response (excerpt):**  
- Remove ProductReader/ProductWriter entirely.  
- Instantiate `CSVProcessor` in main and call `process(inputPath, outputPath)`.  
- Validate that args length is 2 (input and output CSV).  

---

### Notes
- I adapted the AI’s suggestions to match my existing `ProductTransformer` logic from Assignment 2.  
- I verified that the redesigned pipeline produces the same output as the original Assignment 2 solution.
o