package org.sun.chapter4.section1;

public abstract class AbsSymbolGraph {

    /**
     * build graph specified in filename using delim to separate vertex names
     *
     * @param filename
     * @param delim
     */
    public AbsSymbolGraph(String filename, String delim) {
    }

    /**
     * is key a vertex
     *
     * @param key
     * @return
     */
    abstract boolean contains(String key);

    /**
     * index associated with key
     *
     * @param key
     * @return
     */
    abstract int index(String key);

    /**
     * key associated with index
     *
     * @param v
     * @return
     */
    abstract String name(int v);

    /**
     * underlying Graph
     *
     * @return
     */
    abstract AbsGraph G();
}
