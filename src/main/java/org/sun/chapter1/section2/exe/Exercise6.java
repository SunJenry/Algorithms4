package org.sun.chapter1.section2.exe;

public class Exercise6 {
    public static void main(String[] args) {

    }

    public static boolean isCircularRotation(String r1, String r2) {
        return r1.length() == r2.length() && (r1 + r1).contains(r2);
    }
}
