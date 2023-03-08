package org.sun.chapter1.section4.exe;

public class Exe35 {
    public static void main(String[] args) {
        /**
         * LinkedList
         * int -> N(N for enclosure reference) + N(N for next reference) = 2*N
         *     -> N(N node created) = N
         * Int -> N(N for enclosure reference) + N(N for next reference) + N(N for Integer) = 3*N
         *     -> N(N node created) + N(N integer) = 2*N
         * Array
         * int -> ~4N(resizing, so the array may occupy 25%~100%) + N
         *     -> lgN
         *
         * Int -> ~5N
         *     -> N + lgN = ~N
         */
    }
}
