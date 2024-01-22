package Exercise.Chapter1_3;

import Exercise.Chapter1_3.Ex19.LinkedList;

public class Ex28 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(20);
        linkedList.add(5);

        System.out.println("max: " + max(linkedList.first()));
    }

    public static int max(LinkedList<Integer>.Node firstNode) {
        LinkedList<Integer>.Node current = firstNode;
        if (firstNode == null) {
            return 0;
        }

        if (current.next == null) {
            return current.item;
        }

        return Math.max(current.item, max(current.next));
    }
}
