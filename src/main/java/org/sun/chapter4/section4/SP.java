package org.sun.chapter4.section4;

import org.sun.chapter1.section3.Stack;

public class SP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public SP(EdgeWeightedDigraph G, int s) {
    }

    /**
     * distance from s to v, infinite if no path
     *
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * path from s to v?
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> directedEdges = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            directedEdges.push(e);
        }

        return directedEdges;
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();

        if (distTo(w) > distTo(v) + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
