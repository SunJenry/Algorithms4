package org.sun.chapter3.section4;

/**
 * ALGORITHM 3.5
 * <p>
 * Hashing with separate chaining.
 *
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;//number of key-value pairs
    private int M;//

    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        M = m;

        st = new SequentialSearchST[M];

        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(value);
    }

    public Iterable<Key> keys() {
        return null;
    }
}
