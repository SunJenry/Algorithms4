package org.sun.chapter4.section1;

import org.sun.util.In;

public abstract class AbsGraph {

    /**
     * create a V-vertex graph with no edges
     *
     * @param V
     */
    public AbsGraph(int V) {
    }

    /**
     * read a graph from input steam in
     *
     * @param in
     */
    public AbsGraph(In in) {
    }

    /**
     * number of vertices
     *
     * @return
     */
    public abstract int V();

    /**
     * number of edges
     *
     * @return
     */
    public abstract int E();

    /**
     * add edge v-w to this graph
     *
     * @param v
     * @param w
     */
    public abstract void addEdge(int v, int w);

    /**
     * vertices adjacent to v
     *
     * @param v
     * @return
     */
    public abstract Iterable<Integer> adj(int v);

    public abstract boolean hasEdge(int w, int v);

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(V() + " vertices, " + E() + " edges\n");
        for (int v = 0; v < V(); v++) {
            s.append(v).append(": ");
            for (int w :
                    adj(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }

    /**
     * compute the degree of V
     *
     * @param G
     * @param v
     * @return
     */
    public static int degree(AbsGraph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }

        return degree;
    }

    /**
     * compute maximum degree
     *
     * @param G
     * @return
     */
    public static int maxDegree(AbsGraph G) {
        int max = 0;
        for (int i = 0; i < G.V(); i++) {
            if (degree(G, i) > max) {
                max = degree(G, i);
            }
        }

        return max;
    }

    /**
     * compute average degree
     *
     * @param G
     * @return
     */
    public static int avgDegree(AbsGraph G) {
        return 2 * G.E() / G.V();
    }

    /**
     * count self-loops
     *
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(AbsGraph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w :
                    G.adj(v)) {
                if (v == w) count++;
            }
        }

        return count / 2;//each edge counted twice
    }
}
