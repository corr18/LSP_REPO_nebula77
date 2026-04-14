package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    // ── isEmpty ──────────────────────────────────────────────
    @Test
    public void testIsEmpty_emptySet() {
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testIsEmpty_nonEmptySet() {
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    // ── clear ────────────────────────────────────────────────
    @Test
    public void testClear_normal() {
        set1.add(1); set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testClear_alreadyEmpty() {
        set1.clear(); // should not throw
        assertTrue(set1.isEmpty());
    }

    // ── length ───────────────────────────────────────────────
    @Test
    public void testLength_normal() {
        set1.add(1); set1.add(2); set1.add(3);
        assertEquals(3, set1.length());
    }

    @Test
    public void testLength_emptySet() {
        assertEquals(0, set1.length());
    }

    // ── contains ─────────────────────────────────────────────
    @Test
    public void testContains_valuePresent() {
        set1.add(5);
        assertTrue(set1.contains(5));
    }

    @Test
    public void testContains_valueNotPresent() {
        assertFalse(set1.contains(99));
    }

    // ── add ──────────────────────────────────────────────────
    @Test
    public void testAdd_normal() {
        set1.add(10);
        assertTrue(set1.contains(10));
    }

    @Test
    public void testAdd_duplicate() {
        set1.add(10);
        set1.add(10); // duplicate — should not increase length
        assertEquals(1, set1.length());
    }

    // ── remove ───────────────────────────────────────────────
    @Test
    public void testRemove_normal() {
        set1.add(3);
        set1.remove(3);
        assertFalse(set1.contains(3));
    }

    @Test
    public void testRemove_valueNotPresent() {
        assertDoesNotThrow(() -> set1.remove(99));
    }

    // ── equals ───────────────────────────────────────────────
    @Test
    public void testEquals_sameElementsDifferentOrder() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(3); set2.add(1); set2.add(2);
        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEquals_differentElements() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        assertFalse(set1.equals(set2));
    }

    // ── largest ──────────────────────────────────────────────
    @Test
    public void testLargest_normal() throws Exception {
        set1.add(1); set1.add(5); set1.add(3);
        assertEquals(5, set1.largest());
    }

    @Test
    public void testLargest_singleElement() throws Exception {
        set1.add(42);
        assertEquals(42, set1.largest());
    }

    @Test
    public void testLargest_emptySetThrows() {
        assertThrows(Exception.class, () -> set1.largest());
    }

    // ── smallest ─────────────────────────────────────────────
    @Test
    public void testSmallest_normal() throws Exception {
        set1.add(4); set1.add(1); set1.add(7);
        assertEquals(1, set1.smallest());
    }

    @Test
    public void testSmallest_singleElement() throws Exception {
        set1.add(7);
        assertEquals(7, set1.smallest());
    }

    @Test
    public void testSmallest_emptySetThrows() {
        assertThrows(Exception.class, () -> set1.smallest());
    }

    // ── union ────────────────────────────────────────────────
    @Test
    public void testUnion_normal() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2) &&
                   set1.contains(3) && set1.contains(4));
    }

    @Test
    public void testUnion_withEmptySet() {
        set1.add(1); set1.add(2);
        set1.union(set2); // set2 is empty
        assertEquals(2, set1.length());
    }

    // ── intersect ────────────────────────────────────────────
    @Test
    public void testIntersect_normal() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.contains(2) && set1.contains(3));
        assertEquals(2, set1.length());
    }

    @Test
    public void testIntersect_noCommonElements() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.isEmpty());
    }

    // ── diff ─────────────────────────────────────────────────
    @Test
    public void testDiff_normal() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2);
        set1.diff(set2);
        assertTrue(set1.contains(1) && set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    public void testDiff_identicalSets() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2);
        set1.diff(set2);
        assertTrue(set1.isEmpty());
    }

    // ── complement ───────────────────────────────────────────
    @Test
    public void testComplement_normal() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2); set2.add(3); set2.add(4);
        set1.complement(set2);
        assertTrue(set1.contains(3) && set1.contains(4));
    }

    @Test
    public void testComplement_disjointSets() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.complement(set2);
        assertTrue(set1.contains(3) && set1.contains(4));
    }

    // ── toString ─────────────────────────────────────────────
    @Test
    public void testToString_normal() {
        set1.add(1); set1.add(2); set1.add(3);
        // Elements must appear in some consistent order per your implementation
        assertNotNull(set1.toString());
        assertTrue(set1.toString().startsWith("[") && set1.toString().endsWith("]"));
    }

    @Test
    public void testToString_emptySet() {
        assertEquals("[]", set1.toString());
    }
}