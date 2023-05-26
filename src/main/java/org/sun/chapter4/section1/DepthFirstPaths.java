package org.sun.chapter4.section1;

import org.sun.chapter1.section3.Stack;

public class DepthFirstPaths extends AbsPath {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(AbsGraph G, int s) {
        super(G, s);

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        this.s = s;

        dfs(G, s);
    }

    private void dfs(AbsGraph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            edgeTo[w] = s;
            if (!marked[w]) dfs(G, w);
        }
    }

    @Override
    boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);

        return path;
    }
}
