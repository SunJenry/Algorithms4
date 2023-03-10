package org.sun.chapter1.section5.exe;

import org.sun.chapter1.section5.QuickUnion;
import org.sun.chapter1.section5.WeightQuickUnion;
import org.sun.util.StdRandom;

public class Exe17 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        erdosRenyi(N);
    }

    private static int erdosRenyi(int n) {
        int pairCount = 0;

        WeightQuickUnion weightQuickUnion = new WeightQuickUnion(n);
        while (weightQuickUnion.getCount() != 1) {
            pairCount++;
            int i = StdRandom.uniformInt(n);
            int j = StdRandom.uniformInt(n);

            if (!weightQuickUnion.connected(i, j)) {
                weightQuickUnion.union(i, j);
            }
        }

        return pairCount;
    }
}
