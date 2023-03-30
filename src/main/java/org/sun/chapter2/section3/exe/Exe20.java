package org.sun.chapter2.section3.exe;

import org.sun.chapter1.section3.Stack;
import org.sun.util.StdOut;
import org.sun.util.Util;

import java.util.Arrays;

import static org.sun.chapter2.section2.exe.Exe12.isSorted;

public class Exe20 {

    public static class Range {
        int low;
        int hi;

        public Range(int low, int hi) {
            this.low = low;
            this.hi = hi;
        }
    }

    public static void main(String[] args) {
        Comparable[] comparables = Util.generateRandomArray(20);
        quicksortWithNoRecursive(comparables);
        StdOut.println(Arrays.toString(comparables));
        isSorted(comparables);
    }

    public static void quicksortWithNoRecursive(Comparable[] array) {
        Range range = new Range(0, array.length - 1);
        Stack<Range> ranges = new Stack<>();
        ranges.push(range);

        while (!ranges.isEmpty()) {
            Range pop = ranges.pop();

            int partition = partition(array, pop.low, pop.hi);

            StdOut.println("partition:" + partition);

            int leftSize = partition - pop.low;
            int rightSize = pop.hi - partition;

            Range rangeLow = new Range(pop.low, partition - 1);
            Range rangeHi = new Range(partition + 1, pop.hi);

            if (leftSize > rightSize) {
                if (leftSize > 1) {
                    ranges.push(rangeLow);
                }

                if (rightSize > 1) {
                    ranges.push(rangeHi);
                }
            } else {
                if (rightSize > 1) {
                    ranges.push(rangeHi);
                }

                if (leftSize > 1) {
                    ranges.push(rangeLow);
                }
            }

        }
    }

    private static int partition(Comparable[] array, int low, int hi) {
        int i = low;
        int j = hi + 1;

        Comparable pivot = array[low];

        while (true) {
            while (array[++i].compareTo(pivot) < 0) {
                if (i >= hi) break;
            }

            while (array[--j].compareTo(pivot) > 0) {
                if (j <= low) break;
            }

            if (i >= j) {
                break;
            }

            exch(array, i, j);
        }

        exch(array, low, j);

        return j;
    }

    private static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
