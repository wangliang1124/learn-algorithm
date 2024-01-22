package Exercise.Chapter1_3;

import java.util.LinkedList;

import edu.princeton.cs.algs4.StdOut;

public class Ex21 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("A");
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");

        StdOut.println("Find B result: " + find(linkedList, "B") + " Expected: true");
        StdOut.println("Find Z result: " + find(linkedList, "Z") + " Expected: false");
    }

    public static boolean find(LinkedList<String> linkedlist, String key) {
        for (String item : linkedlist) {
            if (item.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
