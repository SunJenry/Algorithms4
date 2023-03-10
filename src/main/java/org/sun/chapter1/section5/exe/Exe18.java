package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section3.Bag;

public class Exe18 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        generate(n);
    }

    private static int generate(int n) {
        Bag<Connection> connections = new Bag<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    connections.add(new Connection(i, j));
                }
            }
        }

        return connections.size();
    }

    public static class Connection {
        private int p;
        private int q;

        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
