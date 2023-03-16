package org.sun.chapter2.section2;

public class BottomUpMergeSort extends MergeSort {
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int length = a.length;

        for (int sz = 1; sz < length; sz *= 2) {
            for (int i = 0; i < length - sz; i += sz * 2) {
                int hi = Math.min(length - 1, i + 2 * sz - 1);
                int mid = i + sz - 1;
                merge(a, i, mid, hi);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        BottomUpMergeSort bottomUpMergeSort = new BottomUpMergeSort();
        bottomUpMergeSort.sort(ints);
        bottomUpMergeSort.show(ints);
    }
}
