# AI Usage – Question 2

**AI Tools Used:** Claude (Anthropic)

**Prompts Used:**
1. How does the Template Method design pattern work in Java with an abstract base class?
2. Write a Report abstract class with a final generateReport() template method and four abstract steps.
3. Implement StudentReport and CourseReport subclasses with the required output format.
4. Write a Driver using List<Report> to demonstrate polymorphism.

**How AI Helped:**
AI helped structure the abstract base class correctly — specifically making `generateReport()` final to lock the workflow while keeping the four steps abstract. It also helped produce clean Javadocs and ensured the output matched the expected format exactly.

**Reflection:**
I reinforced that the Template Method pattern separates the stable algorithm skeleton from the parts that vary, which is a direct application of the Open/Closed Principle.
