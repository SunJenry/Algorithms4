package org.sun.chapter2.section2.exe;

public class Exe13 {
    public static void main(String[] args) {
        // N elements have N! kinds order.
        // N elements tree's height is N at most.
        // the number of the leaf node of the tree is not smaller than N! and not larger than 2^N
        // so N! <= number of leaf node <= 2^N
        // log(N!) <= log(number of leaf node) <= N (N can be replaced with the height of the tree) = h
        // h >= log(N!)
        // h >= NlogN (Stirling's formula)
    }
}
