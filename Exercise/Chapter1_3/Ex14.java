package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings(3);

        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("2");
        resizingArrayQueueOfStrings.enqueue("3");
        resizingArrayQueueOfStrings.enqueue("Full");

        StdOut.println("Dequeue 1: " + resizingArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 1\n");

        resizingArrayQueueOfStrings.enqueue("4");
        StdOut.println("Dequeue 2: " + resizingArrayQueueOfStrings.dequeue());
        StdOut.println("Expected: 2");

    }

    static class ResizingArrayQueueOfStrings {
        String[] items;
        int N = 0;
        int head = 0;
        int tail = N;

        public ResizingArrayQueueOfStrings(int capacity) {
            items = new String[capacity];
        }

        public void enqueue(String item) {
            if (N == items.length) {
                resize(2 * items.length);
            }

            if (tail == items.length) {
                tail = 0;
            }

            items[tail++] = item;
            N++;
        }

        public String dequeue() {
            if (!isEmpty()) {
                String item = items[head];
                items[head] = null;
                head++;
                N--;

                if (head == items.length) {
                    head = 0;
                }

                if (N > 0 && N == items.length / 4) {
                    resize(items.length / 2);
                }

                return item;
            } else {
                throw new RuntimeException("Queue underflow");
            }
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        private void resize(int capacity) {
            System.out.println("__resize__");
            String[] temp = new String[capacity];
            for (int i = 0; i < N; i++) {
                temp[i] = items[(head + i) % items.length];
            }

            items = temp;
            head = 0;
            tail = N;
        }
    }
}
