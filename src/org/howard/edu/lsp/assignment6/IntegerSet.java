package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet models a mathematical set of integers.
 * No duplicates are allowed.
 */
public class IntegerSet {

    private ArrayList<Integer> set;

    /**
     * Default constructor
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Clears the set
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns length of set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal
     */
    public boolean equals(IntegerSet b) {
        if (b == null) return false;

        ArrayList<Integer> aList = new ArrayList<>(this.set);
        ArrayList<Integer> bList = new ArrayList<>(b.set);

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    /**
     * Checks if value exists in set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns largest element
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns smallest element
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds item to set (no duplicates)
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes item from set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns union of two sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int val : intSetb.set) {
            if (!result.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    /**
     * Returns intersection of two sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    /**
     * Returns difference (this - b)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (!intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    /**
     * Returns complement (b - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : intSetb.set) {
            if (!this.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    /**
     * Checks if set is empty
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns string representation in ascending order
     */
    @Override
    public String toString() {
        ArrayList<Integer> temp = new ArrayList<>(set);
        Collections.sort(temp);

        return temp.toString();
    }
}