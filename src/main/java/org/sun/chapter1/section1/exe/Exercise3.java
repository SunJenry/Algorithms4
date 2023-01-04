package org.sun.chapter1.section1.exe;

public class Exercise3 {
    public static void main(String[] args) {
        int arg0 = Integer.parseInt(args[0]);
        int arg1 = Integer.parseInt(args[1]);
        int arg2 = Integer.parseInt(args[2]);

        isEqual(arg0, arg1, arg2);
    }

    private static void isEqual(int arg0, int arg1, int arg2) {
        System.out.println("Arg0:" + arg0 + " Arg1:" + arg1 + " Arg2:" + arg2);
        if (arg0 == arg1 && arg1 == arg2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
