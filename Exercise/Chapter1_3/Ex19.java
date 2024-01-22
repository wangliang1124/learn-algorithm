package Exercise.Chapter1_3;

import java.util.Iterator;
import java.util.StringJoiner;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(5);
        linkedList.add(4);

        StdOut.println("Before removing last node");

        StringJoiner listBeforeRemove = new StringJoiner(" ");
        for (int number : linkedList) {
            listBeforeRemove.add(String.valueOf(number));
        }

        StdOut.println(listBeforeRemove.toString());

        // linkedList.deleteLastNode();
        // linkedList.deleteLastNode();
        Integer deleted1 = linkedList.delete(4);
        Integer deleted2 = linkedList.delete(5);
        System.out.println("deleted:" + deleted1 + ":" + deleted2);
        StdOut.println("\nAfter removing nth node");

        StringJoiner listAfterRemove = new StringJoiner(" ");
        for (int number : linkedList) {
            listAfterRemove.add(String.valueOf(number));
        }
        StdOut.println(listAfterRemove.toString());

        LinkedList<Integer>.Node random = linkedList.random();
        linkedList.removeAfter(random);
        StringJoiner listRemoveNode = new StringJoiner(" ");
        for (int number : linkedList) {
            listRemoveNode.add(String.valueOf(number));
        }
        System.out.println("After removing node");
        StdOut.println(listRemoveNode.toString());

        LinkedList<Integer>.Node random1 = linkedList.random();
        LinkedList<Integer>.Node node = linkedList.createNode(7);
        linkedList.insertAfter(random1, node);
        StringJoiner listInsertNode = new StringJoiner(" ");
        for (int number : linkedList) {
            listInsertNode.add(String.valueOf(number));
        }
        System.out.println("After inserting node");
        StdOut.println(listInsertNode.toString());
    }

    public static class LinkedList<Item> implements Iterable<Item> {
        public class Node {
            Item item;
            Node next;
        }

        private int size;
        private Node first;

        public Node createNode(Item item) {
            Node node = new Node();
            node.item = item;
            return node;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void add(Item item) {
            if (isEmpty()) {
                first = new Node();
                first.item = item;
            } else {
                Node current = first;
                while (current.next != null) {
                    current = current.next;
                }

                Node node = new Node();
                node.item = item;
                current.next = node;
            }
            size++;
        }

        public Item deleteLastNode() {
            if (isEmpty()) {
                return null;
            }
            Item ret;
            if (size == 1) {
                ret = first.item;
                first = null;
                size--;
            } else {
                Node current = first;
                while (current.next.next != null) {
                    current = current.next;
                }
                // for (; current.next.next != null; current = current.next) {

                // }
                ret = current.next.item;
                current.next = null;
                size--;
            }
            return ret;
        }

        public Item delete(int k) {
            if (isEmpty()) {
                return null;
            }

            if (k > size || k <= 0) {
                return null;
            }

            Item ret = null;
            if (k == 1) {
                ret = first.item;
                first = first.next;
            } else {
                Node current = first;
                for (int i = 1; i < k - 1; i++) {
                    current = current.next;
                }
                // System.out.println("ret:" + ret);
                ret = current.next.item;
                current.next = current.next.next;
            }

            size--;

            return ret;
        }

        public Node random() {
            return first;
        }

        public Node first() {
            return first;
        }

        // EX24
        public void removeAfter(Node node) {
            if (isEmpty() || node == null || node.next == null) {
                return;
            }

            Node current = first;
            while (current.next != null) {
                if (current == node) {
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }

        // Ex25
        public void insertAfter(Node firstNode, Node secondNode) {
            if (isEmpty() || firstNode == null || secondNode == null) {
                return;
            }
            Node current = first;
            while (current.next != null) {
                if (current == firstNode) {
                    secondNode.next = firstNode.next;
                    firstNode.next = secondNode;
                    size++;
                    break;
                }
                current = current.next;
            }
        }

        public void removeAll(String key) {
            if (isEmpty() || key == null) {
                return;
            }

            while (first != null && first.item.equals(key)) {
                first = first.next;
                size--;
            }

            Node current = first;
            while (current.next != null) {
                while (current.next.item.equals(key)) {
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
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
