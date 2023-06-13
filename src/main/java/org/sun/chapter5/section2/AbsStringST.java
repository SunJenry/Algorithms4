package org.sun.chapter5.section2;

public abstract class AbsStringST<Value> {
    abstract void put(String key, Value val);

    abstract Value get(String key);

    abstract void delete(String key);

    abstract boolean contains(String key);

    abstract boolean isEmpty();

    abstract String longestPrefixOf(String s);

    abstract Iterable<String> keysWithPrefix(String s);

    abstract Iterable<String> keysThatMatch(String s);

    abstract int size();

    abstract Iterable<String> keys();
}
