package org.sun.chapter4.section1;

public abstract class AbsPath {
    public AbsPath(AbsGraph G, int s) {
    }

    abstract boolean hasPathTo(int v);

    abstract Iterable<Integer> pathTo(int v);
}
