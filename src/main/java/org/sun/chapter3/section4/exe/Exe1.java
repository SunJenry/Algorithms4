package org.sun.chapter3.section4.exe;

public class Exe1 {
    public static void main(String[] args) {
        /**
         * 3.4.1
         *
         * key hash value
         *   E   0    0
         *
         * 0 E0
         * 1 null
         * 2 null
         * 3 null
         * 4 null
         *
         * key hash value
         *   A   1    1
         *
         * 0 E0
         * 1 A1
         * 2 null
         * 3 null
         * 4 null
         *
         * key hash value
         *   S   4    2
         *
         * 0 E0
         * 1 A1
         * 2 null
         * 3 null
         * 4 S2
         *
         * key hash value
         *   Y   0    3
         *
         * 0 E0 -> Y3
         * 1 A1
         * 2 null
         * 3 null
         * 4 S2
         *
         * key hash value
         *   Q   2    4
         *
         * 0 E0 -> Y3
         * 1 A1
         * 2 Q4
         * 3 null
         * 4 S2
         *
         * key hash value
         *   U   1    5
         *
         * 0 E0 -> Y3
         * 1 A1 -> U5
         * 2 Q4
         * 3 null
         * 4 S2
         *
         * key hash value
         *   T   0    6
         *
         * 0 E0 -> Y3 -> T6
         * 1 A1 -> U5
         * 2 Q4
         * 3 null
         * 4 S2
         *
         * key hash value
         *   I   4    7
         *
         * 0 E0 -> Y3 -> T6
         * 1 A1 -> U5
         * 2 Q4
         * 3 null
         * 4 S2 -> I7
         *
         * key hash value
         *   O   0    8
         *
         * 0 E0 -> Y3 -> T6 -> O8
         * 1 A1 -> U5
         * 2 Q4
         * 3 null
         * 4 S2 -> I7
         *
         * key hash value
         *   N   4    9
         *
         * 0 E0 -> Y3 -> T6 -> O8
         * 1 A1 -> U5
         * 2 Q4
         * 3 null
         * 4 S2 -> I7 -> N9
         */
    }
}
