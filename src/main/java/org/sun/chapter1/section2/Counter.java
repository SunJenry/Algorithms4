package org.sun.chapter1.section2;

public class Counter {

    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        ++count;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" + "name='" + name + '\'' + ", tally=" + count + '}';
    }
}
