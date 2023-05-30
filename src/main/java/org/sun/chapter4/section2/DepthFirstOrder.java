package org.sun.chapter4.section2;

import org.sun.chapter1.section3.Queue;
import org.sun.chapter1.section3.Stack;

public class DepthFirstOrder {

    private final Queue<Integer> pre;
    private final Queue<Integer> post;
    private final Stack<Integer> reversePost;
    private final boolean[] marked;

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        marked = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {

        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        post.enqueue(v);
        reversePost.push(v);
    }

    public Queue<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
