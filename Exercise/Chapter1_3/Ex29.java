package Exercise.Chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/* 
 * https://algs4.cs.princeton.edu/13stacks/LinkedQueue.java.html
 */
public class Ex29 {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(9);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeque();
        queue.dequeque();

        StdOut.println("Queue items: " + queue.toString());
        StdOut.println("Expected: 2 9 3 4");
    }

    public static class LinkedQueue<Item> implements Iterable<Item> {
        private int n;
        // private Node first;
        private Node last;

        private class Node {
            private Item item;
            private Node next;
        }

        public LinkedQueue() {
            // first = null;
            last = null;
            n = 0;
        }

        public boolean isEmpty() {
            // return first == null;
            return n == 0;
        }

        public int size() {
            return n;
        }

        public void enqueue(Item item) {
            Node oldlast = last;
            last = new Node();
            last.item = item;

            if (isEmpty()) {
                // first = last;
                last.next = last;
            } else {
                last.next = oldlast.next;
                oldlast.next = last;
            }
            n++;
        }

        public Item dequeque() {
            if (isEmpty())
                throw new NoSuchElementException("Queue underflow");

            Item item = last.next.item;

            n--;
            if (isEmpty()) {
                last = null;
            } else {
                last.next = last.next.next;
            }
            return item;
            // Item item = first.item;
            // first = first.next;
            // n--;
            // if (isEmpty()) {
            // last = null;
            // }
            // return item;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Item item : this) {
                builder.append(item + " ");
            }
            return builder.toString();
        }

        @Override
        public Iterator<Item> iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator<Item> {
            private Node current;
            int count = 0;

            public QueueIterator() {
                if (last != null) {
                    current = last.next;
                } else {
                    current = last;
                }
            }

            public boolean hasNext() {
                return count < size();
            };

            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                count++;
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }
}
