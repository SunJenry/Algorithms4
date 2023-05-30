package org.sun.chapter4.section1;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter1.section3.Stack;

public class BreadFirstPaths extends AbsPath {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    private int[] disTo;

    public BreadFirstPaths(AbsGraph G, int s) {
        super(G, s);

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        disTo = new int[G.V()];

        disTo[s] = 0;
        for (int vertex = 0; vertex < G.V(); vertex++) {
            if (vertex == s) {
                continue;
            }
            disTo[vertex] = Integer.MAX_VALUE;
        }

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

                    disTo[w] = disTo[v] + 1;

                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
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

    public int disTo(int v) {
        return disTo[v];
    }
}
