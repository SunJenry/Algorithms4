package org.sun.chapter4.section3;

public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * weight of this edge
     *
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * either of this edge's vertices
     *
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * the other vertex
     *
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    /**
     * compare this edge to e
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
