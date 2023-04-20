package org.sun.chapter3.section1;

public class ArrayST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private Key[] keys;
    private Value[] values;

    private int size;

    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (value == null) {
            delete(key);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (size == keys.length) {
            resize(2 * size);
        }

        keys[size] = key;
        values[size] = value;

        ++size;
    }

    private void resize(int newSize) {
        Key[] resizeKeys = (Key[]) new Object[newSize];
        Value[] resizeValues = (Value[]) new Object[newSize];

        System.arraycopy(this.keys, 0, resizeKeys, 0, size);
        System.arraycopy(this.values, 0, resizeValues, 0, size);

        keys = resizeKeys;
        values = resizeValues;
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];

                keys[size - 1] = null;
                values[size - 1] = null;

                size--;

                break;
            }
        }

        if (size < keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}
