package org.sun.chapter1.section5;

public class WeightQuickFind extends AbsUF {

    private int[] size;

    public WeightQuickFind(int N) {
        super(N);

        size = new int[N];

        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        int pSize = size[pId];
        int qSize = size[qId];

        int smallSizeId;
        int largeSizeId;
        if (pSize > qSize) {
            smallSizeId = qId;
            largeSizeId = pId;
        } else {
            smallSizeId = pId;
            largeSizeId = qId;
        }

        size[largeSizeId] += size[smallSizeId];

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == smallSizeId) {
                ids[i] = largeSizeId;
            }
        }

        count--;
    }

    @Override
    public int find(int p) {
        return ids[p];
    }
}
