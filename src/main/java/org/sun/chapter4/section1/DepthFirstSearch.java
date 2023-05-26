package org.sun.chapter4.section1;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(AbsGraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(AbsGraph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
