package org.sun.chapter4.section1;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter1.section3.Stack;

public class BreadFirstPaths extends AbsPath {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadFirstPaths(AbsGraph G, int s) {
        super(G, s);

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        bfs(G, s);
    }

    private void bfs(AbsGraph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();

        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }

        path.push(s);

        return path;
    }
}
