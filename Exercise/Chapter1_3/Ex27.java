package Exercise.Chapter1_3;

import Exercise.Chapter1_3.Ex19.LinkedList;

public class Ex27 {
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
        int max = 0;
        LinkedList<Integer>.Node current = firstNode;
        while (current != null) {
            if (current.item > max) {
                max = current.item;
            }
            current = current.next;
        }

        return max;
    }
}
