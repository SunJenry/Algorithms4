package org.sun.chapter4.section4;

import org.sun.chapter1.section3.Bag;

public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;

        adj = new Bag[v];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> directedEdges = new Bag<>();
        for (int i = 0; i < V; i++) {
            for (DirectedEdge directEdge : adj(i)) {
                directedEdges.add(directEdge);
            }
        }

        return directedEdges;
    }
}
