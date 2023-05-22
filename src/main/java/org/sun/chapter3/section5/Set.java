package org.sun.chapter3.section5;

public abstract class Set<Key> {
    abstract void add(Key key);

    abstract void delete(Key key);

    abstract boolean contains(Key key);

    abstract boolean isEmpty();

    abstract int size();
}
