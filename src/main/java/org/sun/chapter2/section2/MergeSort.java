package org.sun.chapter2.section2;

import org.sun.chapter2.AbsSort;

public class MergeSort extends AbsSort {

    protected Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) return;

        int mid = (lo + hi) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {9, 8, 6, 5, 7, 4, 2, 3, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(ints);
        mergeSort.show(ints);
    }
}
