package org.sun.chapter4.section2;

public abstract class AbsDirectDFS {
    public AbsDirectDFS(AbsDigraph G, int s) {
    }

    public AbsDirectDFS(AbsDigraph G, Iterable<Integer> sources) {
    }

    public abstract boolean marked(int v);

}
