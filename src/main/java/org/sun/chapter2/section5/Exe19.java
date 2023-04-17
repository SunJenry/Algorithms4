package org.sun.chapter2.section5;

public class Exe19 {
    public static void main(String[] args) {
        int[] array1 = {0, 3, 1, 6, 2, 5, 4};
        int[] array2 = {1, 0, 3, 6, 4, 2, 5};

        int kendallTau = kendallTau(array1, array2);
    }

    public static int kendallTau(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException();
        }

        int[] array1Inverted = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array1Inverted[array1[i]] = i;
        }

        int[] inversions = new int[array2.length];
        for (int i = 0; i < array2.length; i++) {
            inversions[i] = array1Inverted[array2[i]];
        }

        return countInversions(inversions);
    }

    private static int countInversions(int[] inversions) {
        int[] aux = new int[inversions.length];

        return splitArrayAndCountInversions(inversions, aux, 0, inversions.length - 1);
    }

    private static int splitArrayAndCountInversions(int[] inversions, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }

        int mid = (lo + hi) / 2;

        int inversionInPart1 = splitArrayAndCountInversions(inversions, aux, lo, mid);
        int inversionInPart2 = splitArrayAndCountInversions(inversions, aux, mid + 1, hi);

        int inversionsInBothParts = countInversionsComparingBothParts(inversions, aux, lo, mid, hi);
        return inversionInPart1 + inversionInPart2 + inversionsInBothParts;
    }

    private static int countInversionsComparingBothParts(int[] inversions, int[] aux, int lo, int mid, int hi) {
        int leftIndex = lo;
        int rightIndex = mid + 1;
        int arrayIndex = lo;

        for (int i = lo; i <= hi; i++) {
            aux[i] = inversions[i];
        }

        int inversion = 0;

        while (leftIndex <= mid && rightIndex <= hi) {
            if (aux[leftIndex] <= aux[rightIndex]) {
                inversions[arrayIndex] = aux[leftIndex++];
            } else {
                inversion += mid - leftIndex + 1;
                inversions[arrayIndex] = aux[rightIndex++];
            }
            arrayIndex++;
        }

        while (leftIndex <= mid) {
            inversions[arrayIndex++] = aux[leftIndex++];
        }

        return inversion;
    }
}
