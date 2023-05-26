package org.sun.chapter4.section1;

import org.sun.chapter1.section3.Bag;
import org.sun.util.In;

public class AdjacentListGraph extends AbsGraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public AdjacentListGraph(int V) {
        super(V);

        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public AdjacentListGraph(In in) {
        super(in);
        this.V = in.readInt();


        E = in.readInt();

        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();

            addEdge(v, w);
        }
    }

    @Override
    int V() {
        return V;
    }

    @Override
    int E() {
        return E;
    }

    @Override
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
