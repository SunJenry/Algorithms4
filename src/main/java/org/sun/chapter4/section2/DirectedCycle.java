package org.sun.chapter4.section2;

import org.sun.chapter1.section3.Stack;

public class DirectedCycle {

    private final boolean[] onStack;
    private final int[] edgeTo;
    private final boolean[] marked;

    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }

                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
