package org.sun.chapter5.section4;

import org.sun.chapter1.section3.Bag;
import org.sun.chapter1.section3.Stack;
import org.sun.chapter4.section2.Digraph;
import org.sun.chapter4.section2.DirectedDFS;

public class NFA {

    private char[] re;//match transitions
    private Digraph G;//epsilon transitions
    private int M;//number of states

    public NFA(String regexp) {
        //create the NFA for the given regular expression
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                Integer or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }

            if (i < M - 1 && re[i + 1] == '*') {//lookahead
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }

            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
                G.addEdge(i, i + 1);
            }
        }
    }

    public boolean recognizes(String txt) {
        //Does the NFA recognize the txt?
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) pc.add(v);
        }

        for (int i = 0; i < txt.length(); i++) {
            //Compute possible NFA states
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == txt.charAt(i) || re[v] == '.') {
                        match.add(v + 1);
                    }
                }
            }

            pc = new Bag<Integer>();
            dfs = new DirectedDFS(G, match);

            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }

        for (int v : pc) {
            if (v == M) return true;
        }

        return false;
    }
}
