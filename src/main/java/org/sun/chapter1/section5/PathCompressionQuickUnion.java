package org.sun.chapter1.section5;

import java.util.ArrayList;

public class PathCompressionQuickUnion extends AbsUF {
    public PathCompressionQuickUnion(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        ids[pRoot] = qRoot;

        count--;
    }

    @Override
    public int find(int p) {
        int pBackup = p;
        while (ids[p] != p) {
            p = ids[p];
        }

        while (pBackup != ids[pBackup]) {
            int tempP = pBackup;
            pBackup = ids[pBackup];
            ids[tempP] = p;
        }

        return p;
    }
}
