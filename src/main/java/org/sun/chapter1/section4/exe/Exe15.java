package org.sun.chapter1.section4.exe;

import java.util.Arrays;
import java.util.HashMap;

public class Exe15 {
    public static void main(String[] args) {

    }

    public static int twoSumFast(int[] array) {
        HashMap<Integer, Integer> arrayHashMap = new HashMap<>();

        for (int key : array) {
            Integer count = arrayHashMap.getOrDefault(key, 0);
            arrayHashMap.put(key, ++count);
        }

        int twoSumCount = 0;
        for (int key : array) {
            Integer count = arrayHashMap.get(-key);

            if (key == 0) {
                count--;
            }

            twoSumCount += count;
        }

        return twoSumCount / 2;
    }

    public static int threeSumFast(int[] array) {
        Arrays.sort(array);

        int count = zeroSumCount(array);

        int start;
        int end;

        for (int i = 0; i < array.length; i++) {
            start = i + 1;
            end = array.length - 1;

            while (start < end) {
                int sum = array[i] + array[start] + array[end];
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    //already count all the condition in zeroSumCount()
                    if (array[start] == 0 && array[end] == 0) {
                        break;
                    }

                    //star equals end
                    if (array[start] == array[end]) {
                        int equalElementCount = end - start + 1;
                        count += equalElementCount * (equalElementCount - 1) / 2;
                        break;
                    }

                    //count all equal star/end element
                    int startElement = array[start];
                    int startEqualCount = 1;
                    while (start + 1 < end && startElement == array[start + 1]) {
                        start++;
                        startEqualCount++;
                    }

                    int endElement = array[end];
                    int endEqualCount = 1;
                    while (end - 1 > start && endElement == array[end - 1]) {
                        end--;
                        endEqualCount++;
                    }

                    count += startEqualCount * endEqualCount;

                    start++;
                    end--;
                }
            }
        }

        return count;
    }

    public static int zeroSumCount(int[] array) {
        int i = zeroCount(array);
        return ((i - 2) * (i - 1) * i) / 6;
    }

    public static int zeroCount(int[] array) {
        int count = 0;
        for (int key : array) {
            if (key == 0) {
                count++;
            }
        }

        return count;
    }
}
