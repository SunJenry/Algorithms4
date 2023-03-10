package org.sun.chapter1.section5;

import java.util.Arrays;

public class HeightQuickUnion extends AbsUF {

    private final int[] height;

    public HeightQuickUnion(int N) {
        super(N);

        height = new int[N];
        Arrays.fill(height, 0);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        int pRootHeight = height[pRoot];
        int qRootHeight = height[qRoot];

        if (pRootHeight > qRootHeight) {
            ids[qRoot] = pRoot;
        } else if (pRootHeight < qRootHeight) {
            ids[pRoot] = qRoot;
        } else {
            ids[qRoot] = pRoot;
            height[qRoot] += 1;
        }

        count--;
    }

    @Override
    public int find(int p) {
        while (p != ids[p]) p = ids[p];
        return p;
    }
}
