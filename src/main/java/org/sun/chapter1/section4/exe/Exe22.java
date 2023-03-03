package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

public class Exe22 {
    public static void main(String[] args) {
        int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

        StdOut.println("exist:" + fibonaciSearch(array, 5));
        StdOut.println("exist:" + fibonaciSearch(array, 8));
        StdOut.println("exist:" + fibonaciSearch(array, -3));
        StdOut.println("exist:" + fibonaciSearch(array, -1));
        StdOut.println("exist:" + fibonaciSearch(array, 0));
    }

    public static int fibonaciSearch(int[] array, int key) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int fibonacci0 = 0;
            int fibonacciPre = 1;
            int fibonacci = fibonacci0 + fibonacciPre;

            while (fibonacci < high - low) {
                int aux = fibonacci;
                fibonacci += fibonacciPre;
                fibonacciPre = aux;
            }

            if (fibonacci == 1){
                fibonacci = 0;
            } else {
                fibonacci = fibonacciPre;
            }


            int value = array[low + fibonacci];
            if (value > key) {
                high = low + fibonacci - 1;
            } else if (value < key) {
                low = low + fibonacci + 1;
            } else {
                return low + fibonacci;
            }
        }

        return -1;
    }
}
