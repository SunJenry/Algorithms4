package org.sun.chapter4.section2;

public class KosarajuSharirSCC extends AbsSCC {

    private final boolean[] marked;
    private final int[] id;

    private int count;

    /**
     * preprocessing constructor
     *
     * @param G
     */
    public KosarajuSharirSCC(Digraph G) {
        super(G);

        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder order = new DepthFirstOrder((Digraph) G.reverse());
        for (int s : order.getReversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean stronglyConnected(int w, int v) {
        return id[w] == id[v];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }
}
