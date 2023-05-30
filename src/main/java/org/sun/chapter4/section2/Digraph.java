package org.sun.chapter4.section2;

import org.sun.chapter1.section3.Bag;

public class Digraph extends AbsDigraph {

    private int V;
    private int E;

    private Bag<Integer>[] adj;

    public Digraph(int v) {
        super(v);

        this.V = v;

        this.E = 0;

        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public AbsDigraph reverse() {
        Digraph digraph = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (int w : adj(i)) {
                digraph.addEdge(w, i);
            }
        }
        return digraph;
    }
}
