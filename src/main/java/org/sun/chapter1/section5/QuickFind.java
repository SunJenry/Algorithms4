package org.sun.chapter1.section5;

public class QuickFind extends AbsUF {
    public QuickFind(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }

        count--;
    }

    @Override
    public int find(int p) {
        return ids[p];
    }
}
