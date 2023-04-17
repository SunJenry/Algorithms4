package org.sun.chapter2.section5;

public class Exe17 {

    public static class ValueIndex implements Comparable<ValueIndex> {
        public Comparable comparable;
        public int index;


        @Override
        public int compareTo(ValueIndex o) {
            int compare = this.comparable.compareTo(o.comparable);
            if (compare != 0) {
                return compare;
            }

            return this.index - o.index;
        }
    }

    public static void main(String[] args) {

    }

    public boolean checkArrayIsStable(ValueIndex[] valueIndices) {
        for (int i = 1; i < valueIndices.length; i++) {
            if (valueIndices[i - 1].comparable.compareTo(valueIndices[i].comparable) == 0 && valueIndices[i - 1].index > valueIndices[i].index) {
                return false;
            }
        }

        return true;
    }
}
