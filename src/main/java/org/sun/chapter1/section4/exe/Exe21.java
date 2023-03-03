package org.sun.chapter1.section4.exe;

import org.sun.chapter1.section1.exe.Exercise38;

import java.util.HashSet;

public class Exe21 {
    public static void main(String[] args) {
        //1.filter with set to grantee no repeat value
        //2.use binary search to locate target value


    }

    public static int binarySearchOnDistinctValue(int[] array, int key) {
        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int value : array) {
            integerHashSet.add(value);
        }

        int[] distinctValueArray = new int[integerHashSet.size()];

        int index = 0;
        for (int value : integerHashSet) {
            distinctValueArray[index++] = value;
        }

        return Exercise38.binarySearch(key, distinctValueArray, 0, distinctValueArray.length - 1);
    }
}
