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

        if (N == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;

        N++;
    }

    private void resize(int newSize) {
        Key[] newKeys = (Key[]) new Comparable[newSize];
        Value[] newValues = (Value[]) new Object[newSize];

        System.arraycopy(newKeys, 0, keys, 0, size());
        System.arraycopy(newValues, 0, values, 0, size());

        keys = newKeys;
        values = newValues;
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
        int rank = rank(key);

        if (rank < N && keys[rank].equals(key)) {
            for (int i = rank; i < N - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }

            keys[N - 1] = null;
            values[N - 1] = null;

            N--;

            if (N < keys.length / 4) {
                resize(keys.length / 2);
            }
        }
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
        int rank = rank(key);
        if (keys[rank].equals(key)) {
            return key;
        } else if (rank == 0) {
            return null;
        } else {
            return keys[rank - 1];
        }
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
