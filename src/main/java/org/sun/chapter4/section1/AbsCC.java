package org.sun.chapter4.section1;

public abstract class AbsCC {

    /**
     * preprocessing constructor
     *
     * @param G
     */
    public AbsCC(AbsGraph G) {
    }

    /**
     * are v and w connected?
     *
     * @param v
     * @param w
     * @return
     */
    abstract boolean connected(int v, int w);

    /**
     * number of connected components
     *
     * @return
     */
    abstract int count();

    /**
     * component identifier to v (between 0 and count()-1)
     *
     * @param v
     * @return
     */
    abstract int id(int v);
}
