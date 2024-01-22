package Exercise.Chapter1_3;

import java.util.StringJoiner;

import Exercise.Chapter1_3.Ex19.LinkedList;
import edu.princeton.cs.algs4.StdOut;

public class Ex26 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Mark");
        linkedList.add("Bill");
        linkedList.add("Elon");
        linkedList.add("Rene");
        linkedList.add("Mark");
        linkedList.add("Mark");
        linkedList.add("Mark");
        linkedList.add("Elon");

        linkedList.removeAll("Mark");

        StdOut.println("\nAfter removing Mark");

        StringJoiner listAfterRemove = new StringJoiner(" ");
        for (String name : linkedList) {
            listAfterRemove.add(name);
        }

        StdOut.println(listAfterRemove.toString());
        StdOut.println("Expected: Bill Elon Rene Elon");
    }
}
