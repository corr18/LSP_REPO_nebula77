# AI Usage – Question 3

**AI Tools Used:** Claude (Anthropic)

**Prompts Used:**
1. Write JUnit 5 tests for a GradeCalculator class covering average(), letterGrade(), and isPassing().
2. What boundary values should I test for scores between 0 and 100 and the passing threshold of 60?
3. How do I use assertThrows() in JUnit 5 for IllegalArgumentException?

**How AI Helped:**
AI helped identify the right boundary values (0, 100, 60, 59) and reminded me to use @BeforeEach to avoid repeating new GradeCalculator() in each test. It also showed the correct lambda syntax for assertThrows().

**Reflection:**
I learned that boundary-value analysis is more systematic than I thought — the boundaries are exactly at the edge of each valid range, not just "small" or "large" numbers.
