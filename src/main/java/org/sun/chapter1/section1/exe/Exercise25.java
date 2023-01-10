package org.sun.chapter1.section1.exe;

public class Exercise25 {
    /**
     * if c = gcd(a,b) => ∃ m,n  a=m*c,b=n*c;
     * ∃ k a = k*b +r => r = a - k*b => r = m*c -k*n*c => r = c(m - k*n);
     * gcd(b,r) = gcd(n*c,c(m - k*n)) = c * gcd(n,(m - k*n))
     * so the key is to prove gcd(n,(m - k*n)) = 1
     *
     * if gcd(n,(m - k*n)) = d => ∃ x,y  n=d*x,m-k*n = d*y;
     * m = d*y + k*n => m = d*y+ k*d*x
     * gcd(a,b) = gdc(m*c,n*c) = gcd((d*y+k*d*x)*c,d*x*c) = d*c*gcd((y+k*x),c)
     * ∵ gcd(a,b) = c
     * ∴ d * gcd((y+k*x),c) = 1
     * the only situation is 1*1 = 1,because d and gcd((y+k*x),c) are N+
     * so d = gcd((y+k*x),c) = 1 => gcd(n,(m - k*n)) = d = 1
     * so gcd(b,r) = c * gcd(n,(m - k*n)) = c * 1 = c
     *
     * so gcd(a,b) = gcd(b,r) = gcd(b,a%b)
     *
     * from here we can use Mathematical Induction (MI) to prove Euclidean is right.
     */
}
