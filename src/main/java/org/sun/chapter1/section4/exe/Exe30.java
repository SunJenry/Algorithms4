package org.sun.chapter1.section4.exe;

import org.sun.chapter1.section4.StackAndSteQueueBasedDqueue;

public class Exe30 {
    public static void main(String[] args) {
        StackAndSteQueueBasedDqueue<Integer> integers = new StackAndSteQueueBasedDqueue<>();

        integers.pushLeft(1);
        integers.pushLeft(2);
        integers.pushLeft(3);
        integers.pushLeft(4);
        integers.pushLeft(5);

        //5-4-3-2-1

        integers.popLeft();

        //4-3-2-1

        integers.pushRight(6);

        //4-3-2-1-6

        integers.popRight();

        //4-3-2-1

        integers.pushLeft(7);

        //7-4-3-2-1

        integers.pushRight(8);

        //7-4-3-2-1-8

        integers.popLeft();

        //4-3-2-1-8

        integers.popRight();

        //4-3-2-1

        integers.popRight();

        //4-3-2

        integers.popRight();

        //4-3

        integers.popRight();

        //4
    }
}
