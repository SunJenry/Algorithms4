package org.sun.chapter1.section4.exe;

public class Exe1 {
/**
 * assume P(N) = N(N-1)(N-2)/6
 *
 * when N = 1, P(1) = 0
 * when N = 2, P(2) = 0
 * when N = 3, P(3) = 1
 *
 * assume P(N) = N(N-1)(N-2)/6
 * so P(N+1) = (N+1)N(N-1)/6
 * P(N+1) = P(N) + N(N-1)/2
 * P(N+1) = N(N-1)(N-2)/6 + 3*N(N-1)/3*2
 * P(N+1) = N(N-1)(N+1)/6
 *
 * bingo
 */
}
