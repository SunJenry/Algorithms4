package org.sun.chapter4.section2;

public abstract class AbsSCC {

    /**
     * preprocessing constructor
     *
     * @param G
     */
    public AbsSCC(Digraph G) {
    }

    /**
     * are v and w strongly connected?
     *
     * @param w
     * @param v
     * @return
     */
    public abstract boolean stronglyConnected(int w, int v);

    /**
     * number of strong components
     *
     * @return
     */
    public abstract int count();

    /**
     * component identifier for v
     * between 0 and count()-1
     *
     * @param v
     * @return
     */
    public abstract int id(int v);
}
