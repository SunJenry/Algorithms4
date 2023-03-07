package org.sun.chapter1.section4.exe;

import org.sun.util.Point2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exe26 {
    public static void main(String[] args) {
        //confused by the description of the question.
        //copied directly from Rene Argento.
    }

    // This algorithm can be reduced to 3-SUM since we are searching for
    // a combination of 3 points that can be summed to specific value
    private int countTriples(Point2D[] points) {

        boolean allYCoordinatesAreXCubic = true;

        for (Point2D point2D : points) {

            if (point2D.y() != Math.pow(point2D.x(), 3)) {
                allYCoordinatesAreXCubic = false;
                break;
            }
        }

        if (allYCoordinatesAreXCubic) {
            return countTriplesWithCubicYs(points);
        } else {
            return countTriplesUsingSlopes(points);
        }
    }

    // Based on http://stackoverflow.com/questions/3813681/checking-to-see-if-3-points-are-on-the-same-line
    private int countTriplesUsingSlopes(Point2D[] points) {
        // If (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2) then the points are collinear

        Map<Double, List<Integer>> slopes = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double slope;

                if (points[i].x() - points[j].x() == 0) {
                    slope = 0;
                } else {
                    slope = (points[i].y() - points[j].y()) / (points[i].x() - points[j].x());
                }
                List<Integer> pointIndexes = slopes.get(slope);

                if (pointIndexes == null) {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);

                    slopes.put(slope, indexes);
                } else {
                    if (!slopes.get(slope).contains(i)) {
                        slopes.get(slope).add(i);
                    }
                    if (!slopes.get(slope).contains(j)) {
                        slopes.get(slope).add(j);
                    }
                }
            }
        }

        int triples = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double slope;

                if (points[i].x() - points[j].x() == 0) {
                    slope = 0;
                } else {
                    slope = (points[i].y() - points[j].y()) / (points[i].x() - points[j].x());
                }

                List<Integer> pointIndexes = slopes.get(slope);

                if (pointIndexes != null) {

                    for (Integer index : pointIndexes) {
                        if (index > i && index > j) {
                            triples++;
                        }
                    }
                }
            }
        }

        return triples;
    }

    private int countTriplesWithCubicYs(Point2D[] points) {
        // Based on http://stackoverflow.com/questions/4179581/what-is-the-most-efficient-algorithm-to-find-a-straight-line-that-goes-through-m
        // If the points have the same slope, then they are collinear (on the same line)

        // If x + y + z = 0 then the slope of the line from x to y is
        // (y^3 - x^3) / (y - x) = y^2 + yx + x^2
        // And the slope of the line from x to z is
        //(z^3 - x^3) / (z - x) = z^2 + zx + x^2

        // Conversely, if the slope from x to y equals the slope from x to z then
        // y^2 + yx + x^2 = z^2 + zx + x^2

        // Which implies that
        // (y - z) (x + y + z) = 0
        // So either y = z or z = -x - y which suffices to prove that the reduction is valid

        // If there are duplicates in X, first
        // check whether x + 2y = 0 for any x and duplicate element y
        // (in linear time using hashing or O(n lg n) time using sorting),
        // and then remove the duplicates before reducing to the collinear point-finding problem.

        Map<Double, List<Integer>> pointsX = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            List<Integer> pointIndexes = pointsX.get(points[i].x());

            if (pointIndexes == null) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);

                pointsX.put(points[i].x(), indexes);
            } else {
                pointsX.get(points[i].x()).add(i);
            }
        }

        int triples = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {

                double complementPoint = -1 * (points[i].x() + points[j].x());
                List<Integer> pointIndexes = pointsX.get(complementPoint);

                if (pointIndexes != null) {

                    for (Integer index : pointIndexes) {
                        if (index > i && index > j) {
                            triples++;
                        }
                    }
                }
            }
        }
        return triples;
    }
}
