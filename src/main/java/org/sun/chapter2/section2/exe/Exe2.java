package org.sun.chapter2.section2.exe;

public class Exe2 {
    public static void main(String[] args) {
        /**
         *                                               a[]
         *                           0  1  2  3  4  5  6  7  8  9  10  11
         *                           E  A  S  Y  Q  U  E  S  T  I   O   N
         *        merge(a, 0, 0, 1)  A  E  S  Y  Q  U  E  S  T  I   O   N
         *      merge(a, 0, 1, 2)    A  E  S  Y  Q  U  E  S  T  I   O   N
         *        merge(a, 3, 3, 4)  A  E  S  Q  Y  U  E  S  T  I   O   N
         *      merge(a, 3, 4, 5)    A  E  S  Q  U  Y  E  S  T  I   O   N
         *    merge(a, 0, 2, 5)      A  E  Q  S  U  Y  E  S  T  I   O   N
         *        merge(a, 6, 6, 7)  A  E  Q  S  U  Y  E  S  T  I   O   N
         *      merge(a, 6, 7, 8)    A  E  Q  S  U  Y  E  S  T  I   O   N
         *        merge(a, 9, 9, 10) A  E  Q  S  U  Y  E  S  T  I   O   N
         *      merge(a, 9, 10, 11)  A  E  Q  S  U  Y  E  S  T  I   N   O
         *    merge(a, 6, 8, 11)     A  E  Q  S  U  Y  E  I  N  O   S   T
         *  merge(a, 0, 5, 11)       A  E  E  I  N  O  Q  S  S  T   U   Y
         *                           A  E  E  I  N  O  Q  S  S  T   U   Y
         */
    }
}
