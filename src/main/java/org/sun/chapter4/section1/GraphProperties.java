package org.sun.chapter4.section1;

public class GraphProperties extends AbsGraphProperties {

    private int[] eccentricities;
    private int diameter;
    private int radius;
    private int center;

    public GraphProperties(AbsGraph G) {
        super(G);

        eccentricities = new int[G.V()];


    }

    @Override
    public int eccentricity(int v) {
        return eccentricities[v];
    }

    @Override
    public int diameter() {
        return diameter;
    }

    @Override
    public int radius() {
        return radius;
    }

    @Override
    public int center() {
        return center;
    }
}
