package org.sun.chapter1.section5;

public class WeightQuickUnion extends AbsUF {

    private int[] size;

    public WeightQuickUnion(int N) {
        super(N);

        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        //keep track of the size of each tree and always connect the smaller tree to the larger.
        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

        count--;
    }

    @Override
    int find(int p) {
        while (p != ids[p]) p = ids[p];
        return p;
    }
}
