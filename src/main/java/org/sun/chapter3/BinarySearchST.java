package org.sun.chapter3;

import org.sun.chapter1.section3.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private Key[] keys;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;

        N++;

        if (N == keys.length) {
            resize(2 * keys.length);
        }
    }

    private void resize(int newSize) {

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }

        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int compareMid = keys[mid].compareTo(key);
            if (compareMid > 0) {
                hi = mid - 1;
            } else if (compareMid < 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

//        return rank(key, 0, N - 1);
        return lo;
    }

    private int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;

        int mid = (hi + lo) / 2;

        int compareMid = keys[mid].compareTo(key);
        if (compareMid > 0) {
            return rank(key, lo, mid - 1);
        } else if (compareMid < 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }

        if (contains(hi)) q.enqueue(keys[rank(hi)]);
        return q;
    }
}
