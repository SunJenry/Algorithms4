package org.sun.chapter1.section1.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exercise28 {
    public static void main(String[] args) {
        int[] whitelist = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8};
        int[] target = removeDuplicate(whitelist);
        StdOut.print("Origin:" + Arrays.toString(whitelist) + " Target:" + Arrays.toString(target));
    }

    private static int[] removeDuplicate(int[] whitelist) {
        int[] temp = new int[whitelist.length];
        int count = 0;

        temp[0] = whitelist[0];

        for (int i = 1; i < whitelist.length; i++) {
            if (temp[count] != whitelist[i]) {
                count++;
                temp[count] = whitelist[i];
            }
        }

        int[] target = new int[count + 1];

        System.arraycopy(temp, 0, target, 0, count + 1);
        return target;
    }
}
