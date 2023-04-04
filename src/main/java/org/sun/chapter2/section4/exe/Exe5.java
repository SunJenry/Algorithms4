package org.sun.chapter2.section4.exe;

import org.sun.chapter2.section4.MaxPQ;

public class Exe5 {
    public static void main(String[] args) {
        char[] split = "EASYQUESTION".toCharArray();
        MaxPQ<Character> characterMaxPQ = new MaxPQ<>(split.length);
        for (char ele : split) {
            characterMaxPQ.insert(ele);
            characterMaxPQ.printPQ();
        }
    }
}
