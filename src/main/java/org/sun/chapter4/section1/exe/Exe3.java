package org.sun.chapter4.section1.exe;

import org.sun.chapter1.section3.Bag;
import org.sun.chapter1.section3.Stack;
import org.sun.chapter4.section1.AbsGraph;
import org.sun.chapter4.section1.AdjacentListGraph;

public class Exe3 {


    public class CopyGraph {

        private final int V;
        private int E;
        private Bag<Integer>[] adj;

        public CopyGraph(AdjacentListGraph G) {

            this.V = G.V();
            this.E = G.E();

            this.adj = new Bag[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new Bag<>();
            }

            for (int i = 0; i < V; i++) {
                Stack<Integer> stack = new Stack<>();
                for (int w : G.adj(i)) {
                    stack.push(w);
                }

                for (int w : stack) {
                    adj[i].add(w);
                }
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
            E++;
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    public static void main(String[] args) {

    }
}
