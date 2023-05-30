package org.sun.chapter4.section1.exe;

import org.sun.chapter4.section1.AdjacentListGraph;
import org.sun.util.In;

public class Exe5 {

    public class NoParallelOrSelfLoopsGraph extends AdjacentListGraph {

        public NoParallelOrSelfLoopsGraph(int V) {
            super(V);
        }

        public NoParallelOrSelfLoopsGraph(In in) {
            super(in);
        }

        @Override
        public void addEdge(int v, int w) {
            if (v == w || hasEdge(v, w)) {
                return;
            }
            super.addEdge(v, w);
        }
    }

    public static void main(String[] args) {

    }
}
