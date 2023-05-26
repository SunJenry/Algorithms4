package org.sun.chapter4.section1;

public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(AbsGraph G) {
        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i, i);
            }
        }
    }

    private void dfs(AbsGraph G, int v, int u) {
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean isHasCycle() {
        return hasCycle;
    }
}
