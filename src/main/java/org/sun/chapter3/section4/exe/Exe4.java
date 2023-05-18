package org.sun.chapter3.section4.exe;

import java.util.HashSet;
import java.util.Set;

public class Exe4 {
    public static void main(String[] args) {

    }

    private int[] perfectHashFunction() {
        int[] values = new int[2];

        int[] letterValues = {19, 5, 1, 18, 3, 8, 24, 13, 16, 12};

        for (int m = letterValues.length; m <= 26; m++) {
            for (int a = 1; a < m; a++) {
                Set<Integer> hashes = new HashSet<>();

                for (int letterValue : letterValues) {
                    int hash = hashCodeFunction(a, letterValue, m);
                    hashes.add(hash);
                }

                if (hashes.size() == 10) {
                    //Perfect hash function found
                    values[0] = a;
                    values[1] = m;
                    return values;
                }
            }
        }
        return null;
    }

    private int hashCodeFunction(int a, int k, int m) {
        return (a * k) % m;
    }
}
