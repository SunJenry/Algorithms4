package org.sun.chapter1.section5;

public class QuickUnion extends AbsUF {
    public QuickUnion(int N) {
        super(N);
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        ids[pRoot] = qRoot;

        count--;
    }

    @Override
    int find(int p) {
        while (p != ids[p]) p = ids[p];
        return p;
    }
}
