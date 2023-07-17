package org.sun.chapter5.section3;

/**
 * Boyer-Moore substring search(mismatched character heuristic)
 */
public class BoyerMoore {

    private int[] right;
    private String pat;

    public BoyerMoore(String pat) {
        //Compute skip table
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];

        //-1 for chars not in pattern
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }

        //right most position for chars in pattern
        for (int i = 0; i < M; i++) {
            right[pat.charAt(i)] = i;
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();

        int skip;
        for (int i = 0; i < N - M; i += skip) {
            skip = 0;
            // Does the pattern match the text at position i?
            for (int j = M - 1; j > 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }

            if (skip == 0) return i;//not found
        }

        return N;//not found
    }
}
