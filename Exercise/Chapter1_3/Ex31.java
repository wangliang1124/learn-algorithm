package Exercise.Chapter1_3;

import java.util.Iterator;

public class Ex31 {
    public static class DoublyLinkedList<Item> implements Iterable<Item> {
        private int size;
        private Node first;
        private Node last;

        private class Node {
            Item item;
            Node prev;
            Node next;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void insertAtEnd(Item item) {
            Node oldLast = last;
            Node x = new Node();
            x.item = item;
            x.next = oldLast;
            x.prev = oldLast;
            last = x;

            if (oldLast != null) {
                oldLast.next = last;
            }

            if (isEmpty()) {
                first = last;
            }
            size++;
        }

        public void insertAtBegin(Item item) {
            Node oldFirst = first;
            Node x = new Node();
            x.item = item;
            x.next = oldFirst;
            first = x;

            if (oldFirst != null) {
                oldFirst.prev = first;
            }

            if (isEmpty()) {
                last = first;
            }
            size++;
        }

        @Override
        public Iterator<Item> iterator() {
            return new DoublyLinkedListIterator();
        }

        private class DoublyLinkedListIterator implements Iterator<Item> {

            int index = 0;
            Node current = first;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;

                index++;
                return item;
            }
        }
    }
}
