package org.sun.chapter4.section1;

public class DeepFirstCC extends AbsCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    /**
     * preprocessing constructor
     *
     * @param G
     */
    public DeepFirstCC(AbsGraph G) {
        super(G);

        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(AbsGraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                marked[w] = true;
                dfs(G, w);
            }
        }
    }

    @Override
    boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    int count() {
        return count;
    }

    @Override
    int id(int v) {
        return id[v];
    }
}
