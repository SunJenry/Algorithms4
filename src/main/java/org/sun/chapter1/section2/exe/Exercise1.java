package org.sun.chapter1.section2.exe;

import org.sun.util.Point2D;
import org.sun.util.StdDraw;
import org.sun.util.StdOut;
import org.sun.util.StdRandom;

public class Exercise1 {
    public static void main(String[] args) {
        int n = 10;

        Point2D[] point2DS = new Point2D[n];
        drawPoints(point2DS);

        double shortest = calculateShortest(point2DS);
        StdOut.printf("The shortest distance is: %.3f", shortest);
    }

    private static double calculateShortest(Point2D[] point2DS) {

        double shortestDis = Double.POSITIVE_INFINITY;

        for (int i = 0; i < point2DS.length; i++) {
            for (int j = i + 1; j < point2DS.length; j++) {
                double distance = point2DS[i].distanceTo(point2DS[j]);

                if (distance < shortestDis) {
                    shortestDis = distance;
                }
            }
        }

        return shortestDis;
    }

    private static void drawPoints(Point2D[] point2DS) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < point2DS.length; i++) {
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();
            Point2D point2D = new Point2D(x, y);
            point2DS[i] = point2D;

            StdDraw.point(x, y);
        }
    }
}
