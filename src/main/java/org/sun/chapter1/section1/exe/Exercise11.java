package org.sun.chapter1.section1.exe;

public class Exercise11 {
    public static void main(String[] args) {
        boolean[][] boolArray = {{true, true, true}, {true, true, false}, {true, false, false}, {false, false, false}};

        printArray(boolArray);
    }

    private static void printArray(boolean[][] boolArray) {
        for (int i = 0; i < boolArray.length; i++) {
            boolean[] booleans = boolArray[i];
            for (int j = 0; j < booleans.length; j++) {
                boolean aBoolean = booleans[j];
                if (aBoolean) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
