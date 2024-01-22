package Exercise.Chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Ex15 {
    public static void main(String[] args) {
        int k = StdIn.readInt();
        Queue<String> queue = new Queue<>();

        // while (!StdIn.isEmpty()) {
        // queue.enqueue(StdIn.readString());
        // }
        String[] stringsInput = "A B C D E F G H I J K".split(" ");
        for (String string : stringsInput) {
            queue.enqueue(string);
        }

        System.out.println(findKth(queue, k));
    }

    public static String findKth(Queue<String> queue, int k) {
        int index = 0;
        int size = queue.size();
        for (String item : queue) {
            if (size - index == k) {
                return item;
            }
            index++;
        }

        return "";
    }
}
