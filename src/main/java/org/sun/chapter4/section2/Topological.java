package org.sun.chapter4.section2;

import org.sun.chapter1.section3.Stack;

public class Topological {

    private Stack<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.getReversePost();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }
}
