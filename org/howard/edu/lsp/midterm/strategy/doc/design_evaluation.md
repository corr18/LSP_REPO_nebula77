# PriceCalculator Design Evaluation

The current PriceCalculator design is problematic for several reasons:

1. **Poor Extensibility:** Each new customer type requires modifying the `calculatePrice` method. This violates the Open/Closed Principle because the class must be changed whenever the business adds new customer categories.

2. **Low Cohesion:** The class handles multiple responsibilities — it stores logic for all types of customers and computes their discount. Adding more rules or special cases will further decrease cohesion.

3. **Maintenance Risks:** Hardcoded strings like "REGULAR", "MEMBER", etc., increase the chance of typos. Any change in discount rates requires modifying the class itself, which can introduce errors.

4. **No Reuse:** Discount logic cannot be reused elsewhere because it’s embedded in one method.  

**Conclusion:** The current design is inflexible and difficult to maintain. Using the **Strategy Pattern** allows each customer type’s discount logic to be encapsulated in its own class, making the system easier to extend and maintain.