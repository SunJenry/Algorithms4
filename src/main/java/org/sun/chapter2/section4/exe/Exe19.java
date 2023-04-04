package org.sun.chapter2.section4.exe;

import org.sun.chapter2.section4.MaxPQ;

public class Exe19 {
    public static void main(String[] args) {
        String[] charArray = "a j a o w e i h f o s i d f l s j e l".split(" ");

        MaxPQ<String> characterMaxPQ = new MaxPQ<>(charArray);
        characterMaxPQ.isMaxHeapSorted();
    }
}
