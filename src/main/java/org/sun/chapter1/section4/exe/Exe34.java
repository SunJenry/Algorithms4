package org.sun.chapter1.section4.exe;

public class Exe34 {

    public static int KEY = 8;

    public static void main(String[] args) {

    }

    public static int findTarget2lgN(int[] array) {
        int low = 0;
        int high = array.length - 1;

        int targetIndex = -1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (equalTarget(array[mid])) {
                targetIndex = mid;
                break;
            }

            boolean hot = hotPreviousParam(array[low], array[high]);
            if (hot) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return targetIndex;
    }

    public static boolean equalTarget(int value) {
        return value == KEY;
    }

    public static boolean hotPreviousParam(int previous, int current) {
        return Math.abs(previous - KEY) < Math.abs(current - KEY);
    }
}
