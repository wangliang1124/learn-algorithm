package Exercise.Chapter1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex02 {
    public static void main(String[] args) {
        int N = 5;
        Interval1D[] intervals = getIntervals(N);

        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("Interval 1 - Min: %.3f  Max: %.3f \n", intervals[i].min(), intervals[i].max());
                    StdOut.printf("Interval 2 - Min: %.3f  Max: %.3f \n", intervals[j].min(), intervals[j].max());
                    StdOut.println();
                }
            }
        }
    }

    static Interval1D[] getIntervals(int n) {
        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            double min = StdRandom.uniform();
            double max = StdRandom.uniform();

            if (min > max) {
                double temp = min;
                min = max;
                max = temp;
            }
            intervals[i] = new Interval1D(min, max);
        }
        return intervals;
    }
}
