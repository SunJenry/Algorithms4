package org.sun.chapter4.section3;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter2.section4.IndexMinPQ;

public class PrimMST extends AbsMST {

    private final Edge[] edgeTo;
    private final double[] distTo;
    private final boolean[] marked;
    private final IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        super(G);

        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;//v-w is ineligible
            if (e.weight() < distTo[w]) {
                //Edge e is new best connection from tree to w.
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        Queue<Edge> minimumSpanningTree = new Queue<>();

        for (int vertex = 1; vertex < edgeTo.length; vertex++) {
            minimumSpanningTree.enqueue(edgeTo[vertex]);
        }
        return minimumSpanningTree;
    }

    @Override
    public double weight() {
        double weight = 0;

        for (Edge edge : edges()) {
            weight += edge.weight();
        }
        return weight;
    }
}
