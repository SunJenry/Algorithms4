package org.sun.chapter4.section1;

import org.sun.chapter3.section1.BinarySearchST;
import org.sun.chapter3.section1.ST;
import org.sun.util.In;

public class SymbolGraph extends AbsSymbolGraph {

    private ST<String, Integer> st;
    private String[] keys;
    private AbsGraph G;

    /**
     * build graph specified in filename using delim to separate vertex names
     *
     * @param filename
     * @param delim
     */
    public SymbolGraph(String filename, String delim) {
        super(filename, delim);

        st = new BinarySearchST<>(8);

        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] split = in.readLine().split(delim);
            for (int i = 0; i < split.length; i++) {
                if (!st.contains(split[i])) {
                    st.put(split[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new AdjacentListGraph(st.size());

        in = new In(filename);

        while (in.hasNextLine()) {
            String[] split = in.readLine().split(delim);
            Integer v = st.get(split[0]);
            for (int i = 0; i < split.length; i++) {
                G.addEdge(v, st.get(split[i]));
            }
        }
    }

    @Override
    boolean contains(String key) {
        return st.contains(key);
    }

    @Override
    int index(String key) {
        return st.get(key);
    }

    @Override
    String name(int v) {
        return keys[v];
    }

    @Override
    AbsGraph G() {
        return G;
    }
}
