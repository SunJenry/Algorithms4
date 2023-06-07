package org.sun.chapter4.section3;

import org.sun.chapter1.section3.Queue;

public class LazyPrimMST extends AbsMST {

    private final PriorityQueueResize<Edge> pq;
    private final boolean[] marked;
    private final Queue<Edge> mst;

    public LazyPrimMST(EdgeWeightedGraph G) {
        super(G);

        pq = new PriorityQueueResize<>(PriorityQueueResize.Orientation.MIN);
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);

        while (!pq.isEmpty()) {
            Edge edge = pq.deleteTop(); // get lowest-weight edge from pq
            int v = edge.either();
            int w = edge.other(v);

            if (marked[v] && marked[w]) { //skip if ineligible
                continue;
            }

            mst.enqueue(edge);//add edge to tree

            if (!marked[v]) visit(G, v); //add vertex to tree (either v or w)
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        //marked v and add to pq all edges from v to unmarked vertices
        marked[v] = true;
        for (Edge e : G.adj(G.V())) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        int weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
