package org.sun.chapter4.section3;

public abstract class AbsMST {
    public AbsMST(EdgeWeightedGraph G) {
    }

    public abstract Iterable<Edge> edges();

    public abstract double weight();
}
