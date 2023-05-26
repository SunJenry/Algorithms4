package org.sun.chapter4.section1;

public abstract class AbsSearch {

    /**
     * find vertices connected to a source vertex s
     *
     * @param G
     * @param s
     */
    public AbsSearch(AbsGraph G, int s) {
    }

    /**
     * is v connected to s?
     *
     * @param v
     * @return
     */
    abstract boolean marked(int v);

    /**
     * how many vertices are connected to s?
     *
     * @return
     */
    abstract int count();
}
