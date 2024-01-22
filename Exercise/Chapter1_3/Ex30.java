package Exercise.Chapter1_3;

import java.util.Iterator;
import java.util.StringJoiner;

import edu.princeton.cs.algs4.StdOut;

public class Ex30 {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        linkedList.reverse(linkedList.first());
        // linkedList.reverse2(linkedList.first());

        StringJoiner listItems = new StringJoiner(" ");
        for (int item : linkedList) {
            listItems.add(String.valueOf(item));
        }

        StdOut.println("Reverse list items: " + listItems.toString());
        StdOut.println("Expected: 4 3 2 1");

    }

    public static class LinkedList<Item> implements Iterable<Item> {
        Node first;
        int size = 0;

        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void append(Item item) {
            Node node = new Node();
            node.item = item;
            if (isEmpty()) {
                first = node;
            } else {
                Node current = first;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
            size++;
        }

        public Node first() {
            return first;
        };

        public Node reverse(Node x) {
            Node first = x;
            Node reverse = null;
            while (first != null) {
                Node second = first.next;
                first.next = reverse;
                reverse = first;
                first = second;
            }
            this.first = reverse;
            return reverse;
        }

        public Node reverse2(Node first) {
            if (first == null)
                return null;

            if (first.next == null)
                return first;

            Node second = first.next;
            Node reverse = reverse2(second);
            second.next = first;
            first.next = null;

            this.first = reverse;
            return reverse;
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item> {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;

                return item;
            }
        }
    }
}
