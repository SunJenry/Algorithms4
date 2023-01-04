package org.sun.chapter1.section1.exe;

public class Exercise9 {
    public static void main(String[] args) {
        int x = 1234567;
        String int2BinaryString = int2BinaryString(x);
        System.out.println("int2BinaryString:" + int2BinaryString);
        String binaryString = Integer.toBinaryString(x);
        System.out.println("int2BinaryString:" + binaryString);
    }

    public static String int2BinaryString(int value) {
        String s = "";
        int temp = value;
        while (temp > 0) {
            int i = temp % 2;
            s = i + s;
            temp = temp / 2;
        }

        return s;
    }
}
