package Exercise.Chapter1_2;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex03 {

    // Parameters example: 6 5.5 10.6
    public static void main(String[] args) {
        int N = StdIn.readInt();
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();

        Interval2D[] intervals = new Interval2D[N];
        createAndDrawIntervals(intervals, min, max);

        int[] results = new int[2];
        results[0] = countIntervalIntersections(intervals);
        results[1] = countIntervalContains(intervals);
        StdOut.println("Pairs of intervals that intersect: " + results[0]);
        StdOut.println("Intervals contained in one another: " + results[1]);
    }

    private static Map<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    static void createAndDrawIntervals(Interval2D[] intervals, double min, double max) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < intervals.length; i++) {
            Interval1D x = generateInterval1D(min, max);
            Interval1D y = generateInterval1D(min, max);

            Interval2D interval = new Interval2D(x, y);
            interval.draw();

            intervals[i] = interval;
            intervalMap.put(interval, new Interval1D[] { x, y });
        }
    }

    static Interval1D generateInterval1D(double min, double max) {
        double x1 = StdRandom.uniform(min, max);
        double x2 = StdRandom.uniform(min, max);

        if (x1 > x2) {
            double t = x1;
            x1 = x2;
            x2 = t;
        }

        return new Interval1D(x1, x2);
    }

    static int countIntervalIntersections(Interval2D[] intervals) {
        int intersections = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersections++;
                }
            }
        }

        return intersections;
    }

    static int countIntervalContains(Interval2D[] intervals) {
        int contains = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                Interval2D interval1 = intervals[i];
                Interval2D interval2 = intervals[j];
                Interval1D[] intervalsFromInterval1 = intervalMap.get(interval1);
                Interval1D[] intervalsFromInterval2 = intervalMap.get(interval2);

                // Is interval1 contained in interval2 OR interval2 contained in interval1 ?
                if ((intervalsFromInterval1[0].min() > intervalsFromInterval2[0].min()
                        && intervalsFromInterval1[0].max() < intervalsFromInterval2[0].max()
                        && intervalsFromInterval1[1].min() > intervalsFromInterval2[1].min()
                        && intervalsFromInterval1[1].max() < intervalsFromInterval2[1].max())
                        ||
                        (intervalsFromInterval2[0].min() > intervalsFromInterval1[0].min()
                                && intervalsFromInterval2[0].max() < intervalsFromInterval1[0].max()
                                && intervalsFromInterval2[1].min() > intervalsFromInterval1[1].min()
                                && intervalsFromInterval2[1].max() < intervalsFromInterval1[1].max())) {
                    contains++;
                }
            }
        }

        return contains;
    }
}
