package org.sun.chapter1.section4.exe;

import org.sun.util.StdOut;

import java.util.Arrays;

public class Exe19 {
    public static void main(String[] args) {
        int matrix1[][] = {{1}};
        int matrix2[][] = {{4, 1}, {3, -2}};
        int matrix3[][] = {{5, 2, 3}, {4, 6, 1}, {7, 8, 9}};
        int matrix4[][] = {{5, 90, 3, 10}, {4, -9, 1, 15}, {7, -1, 9, 19}, {12, 8, 13, 99}};
        int matrix5[][] = {{5, 90, 3, 10}, {4, 1, -7, 15}, {7, -1, -8, 19}, {12, 8, 13, 99}};

        int matrix6[][] ={
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,-1,-1},
                {0,0,0,0,0,-1,-1},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,-9,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix1)));
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix2)));
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix3)));
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix4)));
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix5)));
        StdOut.println("coordinate:" + Arrays.toString(localMinimumInMatrix(matrix6)));
    }

    public static int[] localMinimumInMatrix(int[][] matrix) {

        int length = matrix.length;
        //corner case,just ignore
        if (length == 1) return new int[]{0, 0};

        return localMinimumInMatrix(matrix, 0, length - 1, 0, length - 1);
    }

    private static int[] localMinimumInMatrix(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int[] coordinate = new int[]{-1, -1};

        int rowMid = (rowStart + rowEnd) / 2;
        int columnMid = (columnStart + columnEnd) / 2;

        int minValue = Integer.MAX_VALUE;

        //find min value in the first, middle, and last row, and first, middle, and last column
        for (int i = rowStart; i <= rowEnd; i++) {
            int rowColumnStart = matrix[i][columnStart];
            if (rowColumnStart < minValue) {
                minValue = rowColumnStart;
                coordinate = new int[]{i, columnStart};
            }

            int rowColumnMid = matrix[i][columnMid];
            if (rowColumnMid < minValue) {
                minValue = rowColumnMid;
                coordinate = new int[]{i, columnMid};
            }

            int rowColumnEnd = matrix[i][columnEnd];
            if (rowColumnEnd < minValue) {
                minValue = rowColumnEnd;
                coordinate = new int[]{i, columnEnd};
            }
        }

        for (int i = columnStart; i < columnEnd; i++) {
            int columnRowStart = matrix[rowStart][i];
            if (columnRowStart < minValue) {
                minValue = columnRowStart;
                coordinate = new int[]{rowStart, i};
            }

            int columnRowMid = matrix[rowMid][i];
            if (columnRowMid < minValue) {
                minValue = columnRowMid;
                coordinate = new int[]{rowMid, i};
            }

            int columnRowEnd = matrix[rowEnd][i];
            if (columnRowEnd < minValue) {
                minValue = columnRowEnd;
                coordinate = new int[]{rowEnd, i};
            }
        }

        int currentMinRow = coordinate[0];
        int currentMinColumn = coordinate[1];

        //locate quadrant
        if ((currentMinColumn - 1) >= 0) {
            if (matrix[currentMinRow][currentMinColumn - 1] < minValue) {
                //left
                if (currentMinRow > rowMid) {
                    //bottom
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnStart + 1, columnMid - 1);
                } else {
                    //top
                    return localMinimumInMatrix(matrix, rowStart + 1, rowMid - 1, columnStart + 1, columnMid - 1);
                }
            }
        }

        if ((currentMinRow - 1) >= 0) {
            if (matrix[currentMinRow - 1][currentMinColumn] < minValue) {
                //top
                if (currentMinColumn > columnMid) {
                    //right
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnStart + 1, columnMid - 1);
                } else {
                    //left
                    return localMinimumInMatrix(matrix, rowStart + 1, rowMid - 1, columnStart + 1, columnMid - 1);
                }
            }
        }

        if (currentMinColumn + 1 < matrix.length) {
            if (matrix[currentMinRow][currentMinColumn + 1] < minValue) {
                //right
                if (currentMinRow > rowMid) {
                    //bottom
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnMid + 1, columnEnd - 1);
                } else {
                    //top
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnStart + 1, columnMid - 1);
                }
            }
        }

        if (currentMinRow + 1 < matrix.length) {
            if (matrix[currentMinRow + 1][currentMinColumn] < minValue) {
                //bottom
                if (currentMinColumn > columnMid) {
                    //right
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnMid + 1, columnEnd - 1);
                } else {
                    //left
                    return localMinimumInMatrix(matrix, rowMid + 1, rowEnd - 1, columnStart + 1, columnMid - 1);
                }
            }
        }

        //find it!!!
        return coordinate;
    }
}
