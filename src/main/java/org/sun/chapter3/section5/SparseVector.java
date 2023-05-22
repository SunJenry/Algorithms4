package org.sun.chapter3.section5;

import java.util.Hashtable;

public class SparseVector {
    private Hashtable<Integer, Double> st;

    public SparseVector() {
        this.st = new Hashtable<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keySet()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }
}
