package org.sun.chapter1.section5;

public abstract class AbsUF {

    protected final int[] ids;
    protected int count;

    public AbsUF(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
        count = N;
    }

    public abstract void union(int p, int q);

    public abstract int find(int p);

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public int[] getIds() {
        return ids;
    }
}
