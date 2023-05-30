package org.sun.chapter4.section1;

public abstract class AbsPath {
    public AbsPath(AbsGraph G, int s) {
    }

    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);
}
