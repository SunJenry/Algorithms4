package org.sun.chapter4.section2;

public class DirectedDFS extends AbsDirectDFS {

    private boolean[] marked;

    public DirectedDFS(AbsDigraph G, int s) {
        super(G, s);

        marked = new boolean[G.V()];

        dfs(G, s);
    }

    private void dfs(AbsDigraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public DirectedDFS(AbsDigraph G, Iterable<Integer> sources) {
        super(G, sources);

        marked = new boolean[G.V()];

        for (int w : sources) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }
}
