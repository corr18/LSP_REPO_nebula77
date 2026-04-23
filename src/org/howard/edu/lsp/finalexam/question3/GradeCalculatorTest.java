package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for GradeCalculator.
 */
public class GradeCalculatorTest {

    private GradeCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new GradeCalculator();
    }

    // --- average() ---

    @Test
    void testAverageNormalCase() {
        double result = calc.average(80, 90, 70);
        assertEquals(80.0, result, 0.001, "Average of 80, 90, 70 should be 80.0");
    }

    // --- letterGrade() ---

    @Test
    void testLetterGradeA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void testLetterGradeB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void testLetterGradeC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void testLetterGradeD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void testLetterGradeF() {
        assertEquals("F", calc.letterGrade(50));
    }

    // --- isPassing() ---

    @Test
    void testIsPassingTrue() {
        assertTrue(calc.isPassing(75), "75 should be passing");
    }

    @Test
    void testIsPassingFalse() {
        assertFalse(calc.isPassing(50), "50 should not be passing");
    }

    // --- Boundary values ---

    @Test
    void testAverageBoundaryAllZero() {
        double result = calc.average(0, 0, 0);
        assertEquals(0.0, result, 0.001, "Average of all zeros should be 0.0");
    }

    @Test
    void testAverageBoundaryAllHundred() {
        double result = calc.average(100, 100, 100);
        assertEquals(100.0, result, 0.001, "Average of all 100s should be 100.0");
    }

    @Test
    void testIsPassingAtExactBoundary60() {
        assertTrue(calc.isPassing(60), "60 is the minimum passing average");
    }

    @Test
    void testIsFailingJustBelowBoundary59() {
        assertFalse(calc.isPassing(59), "59 is just below passing");
    }

    // --- Exception tests ---

    @Test
    void testAverageThrowsOnNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(-1, 50, 50),
                "Negative score should throw IllegalArgumentException");
    }

    @Test
    void testAverageThrowsOnScoreOver100() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.average(50, 101, 50),
                "Score > 100 should throw IllegalArgumentException");
    }
}
