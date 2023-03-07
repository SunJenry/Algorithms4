package org.sun.chapter1.section4.exe;

public class Exe24 {
    public static void main(String[] args) {

    }

    public static int findFLogN(int[] floors, int key, int low, int high) {
        int keyIndex = -1;

        while (low < high) {
            int mid = (low + high) / 2;

            int midFloor = floors[mid];
            if (midFloor > key) {
                high = mid - 1;
            } else if (midFloor < key) {
                low = mid + 1;
            } else {
                keyIndex = midFloor;
                break;
            }
        }

        return keyIndex;
    }


    public static int findF2LogF(int[] floors, int key) {

        int maxTryFloor = 1;

        //2^n find first value >= key
        for (int i = 1; maxTryFloor < floors.length; i++) {
            if (floors[maxTryFloor] > key) {
                break;
            }

            if (floors[maxTryFloor] == key) {
                //find key
                return maxTryFloor;
            }

            maxTryFloor = 1 << i;
        }

        int hi = Math.min(maxTryFloor, floors.length);
        int lo = maxTryFloor / 2;

        return findFLogN(floors, key, lo, hi);
    }
}
