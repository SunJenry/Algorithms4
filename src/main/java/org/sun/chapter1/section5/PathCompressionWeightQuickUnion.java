package org.sun.chapter1.section5;

import java.util.Arrays;

public class PathCompressionWeightQuickUnion extends AbsUF {

    private final int[] size;

    public PathCompressionWeightQuickUnion(int N) {
        super(N);
        size = new int[N];

        Arrays.fill(size, 1);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        int pRootSize = size[pRoot];
        int qRootSize = size[qRoot];

        if (pRootSize > qRootSize) {
            ids[qRoot] = pRoot;
            size[pRoot] += qRootSize;
        } else {
            ids[pRoot] = qRoot;
            size[qRoot] += pRootSize;
        }

        count--;
    }

    @Override
    public int find(int p) {
        int pBackup = p;

        while (p != ids[p]) {
            p = ids[p];
        }

        while (pBackup != ids[pBackup]) {
            int tempP = pBackup;
            pBackup = ids[pBackup];
            ids[tempP] = p;
        }

        return 0;
    }
}
