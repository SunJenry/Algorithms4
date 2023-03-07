package org.sun.chapter1.section4.exe;

public class Exe25 {
    public static void main(String[] args) {

    }

    public static int findFSqrtN(int[] floors, int key) {
        int startFloor = (int) Math.sqrt(floors.length);
        int low = 0;
        int high = startFloor;

        // increase by SqrtN each time,max SqrtN times.
        for (int i = 1; high < floors.length; i++) {
            if (floors[high] >= key) {
                break;
            }

            low = startFloor * i;
            high = startFloor * (i + 1);
        }

        int maxFloor = Math.min(high, floors.length);

        //linear find in SqrtN,max SqrtN times.
        int index = -1;
        for (int i = low + 1; i <= maxFloor; i++) {
            if (floors[i] == key) {
                index = i;
                break;
            }
        }

        //total ~2SqrtN

        return index;
    }

    public static int findFSqrtF(int[] floors, int key) {
        int currentFloor = 1;
        int previousFloor = 0;
        for (int i = 0; currentFloor < floors.length; i++) {

            if (floors[currentFloor] >= key) {
                break;
            }

            previousFloor = currentFloor;
            currentFloor += i;
        }

        int index = -1;
        for (int i = previousFloor + 1; i < Math.min(currentFloor, floors.length); i++) {
            if (floors[i] == key) {
                index = i;
                break;
            }
        }

        return index;
    }
}
