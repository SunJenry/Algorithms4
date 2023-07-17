package org.sun.chapter5.section3;

public class RabinKarp {

    private String pat;
    private int M;
    private long Q;

    private int R = 256;
    private long RM;//R^(M-1) % Q

    private long patHash;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();

        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i < M; i++) {
            RM = (R * RM) % Q;
        }

        patHash = hash(pat, M);
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R * h + key.charAt(i)) % Q;
        }
        return h;
    }

    private long longRandomPrime() {
        return 0;
    }

    private int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash) return 0;
        for (int i = M; i < N; i++) {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) if (check(i - M + 1)) return i - M + 1;
        }

        return N;
    }

    private boolean check(int i) {
        return true;
    }
}
