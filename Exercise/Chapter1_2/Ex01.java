package Exercise.Chapter1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex01 {
    public static void main(String[] args) {
        int N = 5;
        Point2D[] points = new Point2D[N];
        createAndDrwaPoints(points);
    }

    private static void createAndDrwaPoints(Point2D[] points) {
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < points.length; i++) {
            double pointX = StdRandom.uniform();
            double pointY = StdRandom.uniform();

            Point2D point = new Point2D(pointX, pointY);
            // StdDraw.point(point.x(), point.y());
            point.draw();

            points[i] = point;
        }

        StdOut.printf("The shortest distance is %.3f", calculateShortestDistance(points));
    }

    private static double calculateShortestDistance(Point2D[] points) {
        double shortestDistance = Double.MAX_VALUE;
        double currentDistance;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.001);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point2D pointI = points[i];
                Point2D pointJ = points[j];
                pointJ.drawTo(pointI);
                currentDistance = pointI.distanceTo(pointJ);
                StdDraw.text((pointJ.x() + pointI.x()) / 2, (pointJ.y() + pointI.y()) / 2,
                        String.format("%.3f", currentDistance));

                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                }
            }
        }

        return shortestDistance;
    }
}
