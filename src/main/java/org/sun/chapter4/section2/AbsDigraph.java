package org.sun.chapter4.section2;

public abstract class AbsDigraph {

    public AbsDigraph(int v) {
    }

    public abstract int V();

    public abstract int E();

    public abstract void addEdge(int v, int w);

    public abstract Iterable<Integer> adj(int v);

    public abstract AbsDigraph reverse();

}
