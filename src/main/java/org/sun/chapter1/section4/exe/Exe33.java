package org.sun.chapter1.section4.exe;

public class Exe33 {
    public static void main(String[] args) {
        //Integer 8+4 = 12
        //Date 8+4*3 = 20
        //Counter 8+4+4 = 16
        //int[] 8+4+4*N = 12+4*N
        //double[] 8+4+8*N = 12+8*N
        //double[][] 8+4+4*row+row*(8+4+8*column) = 12+row*(16+8*column)
        //String 8+4+4(hash)+(8+4)(char[] overhead)+2*N(char[] size) = 28+2*N
        //Node 8+4+4+4(extra reference to the enclosure reference) = 20
        //Stack 8+4+4+(8+4+4+4)*N+12N = 16+32N
    }
}
