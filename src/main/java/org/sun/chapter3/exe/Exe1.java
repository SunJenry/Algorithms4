package org.sun.chapter3.exe;

import org.sun.chapter3.BinarySearchST;
import org.sun.util.StdIn;

public class Exe1 {
    public static void main(String[] args) {
        BinarySearchST<String, Double> gradeScoreMap = new BinarySearchST<>(15);
        gradeScoreMap.put("A+", 4.33);
        gradeScoreMap.put("A", 4.00);
        gradeScoreMap.put("A-", 3.67);
        gradeScoreMap.put("B+", 3.33);
        gradeScoreMap.put("B", 3.00);
        gradeScoreMap.put("B-", 2.67);
        gradeScoreMap.put("C+", 2.33);
        gradeScoreMap.put("C", 2.00);
        gradeScoreMap.put("C-", 1.67);
        gradeScoreMap.put("D", 1.00);
        gradeScoreMap.put("F", 0.00);

        String[] grades = StdIn.readAllLines();

        double gpa = computeGPA(gradeScoreMap, grades);
    }

    private static double computeGPA(BinarySearchST<String, Double> gradeScoreMap, String[] grades) {
        double total = 0;
        for (int i = 0; i < grades.length; i++) {
            total += gradeScoreMap.get(grades[i]);
        }
        return total / grades.length;
    }
}
