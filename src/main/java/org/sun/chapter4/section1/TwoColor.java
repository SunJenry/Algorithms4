package org.sun.chapter4.section1;

public class TwoColor {

    private final boolean[] color;
    private boolean[] marked;

    private boolean isTwoColorAble = false;

    public TwoColor(AbsGraph G) {

        marked = new boolean[G.V()];
        color = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(AbsGraph G, int v) {
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorAble = true;
            }
        }
    }

    public boolean isTwoColorAble() {
        return isTwoColorAble;
    }
}
