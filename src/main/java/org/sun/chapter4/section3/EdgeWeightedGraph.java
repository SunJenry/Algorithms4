package org.sun.chapter4.section3;

import org.sun.chapter1.section3.Bag;
import org.sun.util.In;

public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    /**
     * number of vertices
     *
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * number of edges
     *
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * add edge e to this graph
     *
     * @param e
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);

        E++;
    }

    /**
     * edges incident to v
     *
     * @param v
     * @return
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * all of this graph's edges
     *
     * @return
     */
    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int i = 0; i < V(); i++) {
            for (Edge e : adj(i)) {
                if (e.other(i) > i) {
                    edges.add(e);
                }
            }
        }

        return edges;
    }
}
