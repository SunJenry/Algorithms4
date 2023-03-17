package org.sun.chapter2;

import org.sun.util.In;
import org.sun.util.StdOut;

public abstract class AbsSort {

    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                StdOut.println("Not Sorted!!");
                return false;
            }
        }

        StdOut.println("Sorted!!");

        return true;
    }
}
