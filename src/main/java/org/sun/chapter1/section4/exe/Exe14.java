package org.sun.chapter1.section4.exe;

import org.sun.chapter1.section2.StaticSEofInts;

import java.util.Arrays;

public class Exe14 {
    public static void main(String[] args) {

    }

    //n^3*log(n)
    public static int fourSum(int[] array) {
        Arrays.sort(array);

        StaticSEofInts staticSEofInts = new StaticSEofInts(array);

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int target = -1 * (array[i] + array[j] + array[k]);

                    int indexSmallest = staticSEofInts.rankSmallest(target);

                    if (indexSmallest == -1) {
                        continue;
                    }

                    int indexLargest = staticSEofInts.rankLargest(target);

                    if (indexSmallest < k + 1) {
                        if (indexLargest >= k + 1) {
                            indexSmallest = k + 1;
                        } else {
                            continue;
                        }
                    }

                    count = indexLargest - indexSmallest + 1;
                }
            }
        }

        return count;
    }
}
