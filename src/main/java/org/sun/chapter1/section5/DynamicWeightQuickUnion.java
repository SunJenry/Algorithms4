package org.sun.chapter1.section5;

public class DynamicWeightQuickUnion implements IUF {

    private int[] id;
    private int[] size;
    private int currentMaxSite = 0;

    private int count;

    public DynamicWeightQuickUnion() {

    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        int pRootSize = size[pRoot];
        int qRootSize = size[qRoot];

        if (pRootSize > qRootSize) {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }

        count--;
    }

    @Override
    public int find(int p) {
        if (p >= currentMaxSite) {
            throw new IllegalArgumentException();
        }

        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int newSize() {
        if (id == null) {
            id = new int[1];
            size = new int[1];
        }

        if (currentMaxSite == id.length) {
            resize(id.length * 2);
        }

        id[currentMaxSite] = currentMaxSite;
        size[currentMaxSite] = 1;

        currentMaxSite++;
        count++;
        return currentMaxSite;
    }

    private void resize(int newSize) {
        int[] newId = new int[newSize];
        int[] newSizes = new int[newSize];

        for (int i = 0; i < currentMaxSite; i++) {
            newId[i] = id[i];
            newSizes[i] = size[i];
        }

        id = newId;
        size = newSizes;
    }
}
