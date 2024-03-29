package org.sun.chapter5.section3;

public class BruteForceSubstringSearch {
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) return i;//found
        }

        return N;
    }

    public static int searchExplicitBackup(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }

        if (j == M) return i - M;//found
        else return N;
    }
}
