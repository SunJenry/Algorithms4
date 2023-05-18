package org.sun.chapter3.section4;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    private void resize(int newSize) {

    }

    public void put(Key key, Value value) {
        if (N >= M / 2) resize(2 * M);

        int i;

        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);

        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        values[i] = null;

        i = (i + 1) % M;

        while (keys[i] != null) {
            Key keyRedo = keys[i];
            Value valueRedo = values[i];

            keys[i] = null;
            values[i] = null;

            N--;

            put(keyRedo, valueRedo);

            i = (i + 1) % M;
        }

        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    private boolean contains(Key key) {
        return false;
    }
}
