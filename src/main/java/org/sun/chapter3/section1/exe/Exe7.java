package org.sun.chapter3.section1.exe;

import org.sun.chapter3.section1.BinarySearchST;
import org.sun.util.StdOut;
import org.sun.util.Util;

public class Exe7 {

    private static final int UPPER_BOUND_EXCLUSIVE = 1000;

    public static void main(String[] args) {
        new Exe7().doExperiment();
    }

    private void doExperiment() {
        int[] arraySizes = {10, 100, 1000, 10000, 100000, 1000000};

        for (int i = 0; i < arraySizes.length; i++) {
            Integer[] randomArray = Util.generateRandomArray(arraySizes[i], UPPER_BOUND_EXCLUSIVE);
            int distinctKeys = frequencyCounter(randomArray);

            StdOut.println("Number of distinct keys among " + arraySizes[i] + " random nonnegative integers less than " + UPPER_BOUND_EXCLUSIVE + ": " + distinctKeys);
        }
    }

    private int frequencyCounter(Integer[] integers) {

        BinarySearchST<Integer, Integer> binarySearchSymbolTable = new BinarySearchST<>(5);

        for (int integer : integers) {
            if (!binarySearchSymbolTable.contains(integer)) {
                binarySearchSymbolTable.put(integer, 1);
            } else {
                binarySearchSymbolTable.put(integer, binarySearchSymbolTable.get(integer) + 1);
            }
        }

        return binarySearchSymbolTable.size();
    }
}
