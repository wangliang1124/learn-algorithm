package Exercise.Chapter1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10 {
    public static void main(String[] args) {
        int N = 500;
        VisualCounter visualCounter = new VisualCounter(N, 100);

        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.45)) {
                visualCounter.increment();
            } else {
                visualCounter.decrement();
            }
        }
    }

    public static class VisualCounter {
        private int count = 0;
        private int N;
        private int max;
        private int operations = 0;

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = max;

            StdDraw.setCanvasSize(1024, 512);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setXscale(0, N + 1);
            StdDraw.setYscale(-max, max);
        }

        public void increment() {
            if (operations < N && count < max) {
                count++;
                this.operations++;
                plotCounter();
            }
        }

        public void decrement() {
            if (operations < N && count > -max) {
                count--;
                this.operations++;
                plotCounter();
            }
        }

        private void plotCounter() {
            StdDraw.point(operations, count);
        }
    }
}
