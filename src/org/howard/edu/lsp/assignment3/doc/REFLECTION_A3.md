# Assignment 3 Reflection

## Comparison of Assignment 2 vs Assignment 3

In Assignment 2, my ETL pipeline was implemented with a single main class (`ETLPipeline`) and relied on procedural code. Product reading, transforming, and writing were mixed together in one place. The design was functional but not object-oriented; responsibilities were not clearly separated, and all logic resided in `main()`.

In Assignment 3, I redesigned the solution to be more object-oriented. I decomposed the program into four classes:

1. **Product** – encapsulates product data with getters, setters, and `toCSV()` method.  
2. **ProductTransformer** – applies transformation rules to each Product object.  
3. **CSVProcessor** – handles reading input CSV, applying transformations, writing output CSV, and tracking row statistics.  
4. **ETLPipeline** – orchestrates the ETL process and validates command-line arguments.

---

## Object-Oriented Concepts Used

- **Object:** Each product is represented as a `Product` object.  
- **Class:** Each class has a single responsibility (Single Responsibility Principle).  
- **Encapsulation:** Fields in `Product` and `CSVProcessor` are private, accessed through methods.  
- **Polymorphism:** While not heavily used, the design allows easy extension of `ProductTransformer` or `CSVProcessor` via method overloading or subclassing in the future.  
- **Inheritance:** Not explicitly used here, but the design is extensible for future subclasses if needed.  

---

## Design Improvements

- Clear separation of concerns: each class has one responsibility.  
- Transformation logic is isolated in `ProductTransformer`.  
- File I/O and ETL statistics are encapsulated in `CSVProcessor`.  
- ETLPipeline orchestrates the flow but does not contain business logic.  
- Easy to maintain and extend without touching unrelated parts of the code.  

---

## Testing

I tested Assignment 3 by:

1. Using the same `products.csv` input from Assignment 2.  
2. Running the pipeline to generate `transformed_products.csv`.  
3. Comparing output files from Assignment 2 and Assignment 3 to confirm exact match.  
4. Testing edge cases: missing input file, empty input file, and invalid rows to verify proper error handling and row skipping.  

The Assignment 3 implementation produces identical outputs to Assignment 2, but now follows clear object-oriented principles.
