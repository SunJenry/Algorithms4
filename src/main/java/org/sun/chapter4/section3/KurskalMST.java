package org.sun.chapter4.section3;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter1.section5.HeightQuickUnion;
import org.sun.chapter2.section4.IndexMinPQ;

import java.util.Arrays;

public class KurskalMST extends AbsMST {

    private final Queue<Edge> mst;

    private double weight;

    public KurskalMST(EdgeWeightedGraph G) {
        super(G);
        mst = new Queue<>();

        // create array of edges, sorted by weight
        Edge[] edges = new Edge[G.E()];
        int t = 0;
        for (Edge e : G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges);

        // run greedy algorithm
        HeightQuickUnion uf = new HeightQuickUnion(G.V());

        for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            Edge e = edges[i];
            int v = e.either();
            int w = e.other(v);

            // v-w does not create a cycle
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);     // merge v and w components
                mst.enqueue(e);     // add edge e to mst
                weight += e.weight();
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return weight;
    }
}
