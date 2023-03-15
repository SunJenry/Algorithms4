package org.sun.chapter2.section1.exe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exe16 {
    public static void main(String[] args) {

    }

    private static boolean check(Comparable[] array) {
        // Insert all values in the map
        Map<Comparable, Integer> valuesMap = new HashMap<>();

        for (Comparable value : array) {
            int count = 0;

            if (valuesMap.containsKey(value)) {
                count = valuesMap.get(value);
            }

            count++;
            valuesMap.put(value, count);
        }

        Arrays.sort(array);

        // Check if array is sorted
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }

        // Check if the initial set of objects is still in the array
        for (Comparable value : array) {
            if (valuesMap.containsKey(value)) {
                int count = valuesMap.get(value);
                count--;

                if (count == 0) {
                    valuesMap.remove(value);
                } else {
                    valuesMap.put(value, count);
                }
            } else {
                return false;
            }
        }

        return valuesMap.size() <= 0;
    }
}
