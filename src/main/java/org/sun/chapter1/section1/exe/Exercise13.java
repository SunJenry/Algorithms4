package org.sun.chapter1.section1.exe;

import java.util.Arrays;

public class Exercise13 {
    public static void main(String[] args) {
        Integer[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        transposition(a);
    }

    private static <E> void transposition(E[][] a) {
        System.out.println("Origin:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }


        int row = a.length;
        int column = a[0].length;

        E[][] transpositionArray = (E[][]) new Object[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpositionArray[j][i] = a[i][j];
            }
        }

        System.out.println("Transposition:");
        for (int i = 0; i < transpositionArray.length; i++) {
            System.out.println(Arrays.toString(transpositionArray[i]));
        }
    }
}
