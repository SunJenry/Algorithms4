package org.sun.chapter3.section1;

public abstract class ST<Key extends Comparable<Key>, Value> {

    public abstract void put(Key key, Value value);

    public abstract Value get(Key key);

    public abstract void delete(Key key);

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public abstract Key min();

    public abstract Key max();

    public abstract Key floor(Key key);

    public abstract Key ceiling(Key key);

    public abstract int rank(Key key);

    public abstract Key select(int k);

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    public abstract Iterable<Key> keys(Key lo, Key hi);

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

}
