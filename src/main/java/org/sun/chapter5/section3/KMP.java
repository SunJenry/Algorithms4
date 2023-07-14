package org.sun.chapter5.section3;

/**
 * Knuth-Morris-Pratt substring search
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        //Build a DFA from pattern
        this.pat = pat;
        int M = pat.length();
        int R = 256;

        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        //Compute dfa[][]
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];          //Copy mismatch case
            }
            dfa[pat.charAt(j)][j] = j + 1;      //Set match case
            X = dfa[pat.charAt(j)][X];          //Update restart state
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length();
        int M = pat.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == M) return i - M;// found (hit end of pattern)
        else return N;// not found(hit end of txt)
    }
}
