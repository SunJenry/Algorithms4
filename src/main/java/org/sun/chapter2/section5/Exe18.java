package org.sun.chapter2.section5;

import java.util.Arrays;
import java.util.Comparator;

public class Exe18 {
    public static void main(String[] args) {

    }

    /**
     * @param valueIndices
     * @see org.sun.chapter2.section5.Exe17.ValueIndex#compareTo(Exe17.ValueIndex)
     */
    public void forceStable(Exe17.ValueIndex[] valueIndices) {
        Arrays.sort(valueIndices);
    }
}
