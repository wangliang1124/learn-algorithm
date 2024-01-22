package Exercise.Chapter1_3;

public class Ex07 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(10);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("result:" + s.peek());

        s.push(5);
        s.push(6);
        s.pop();
        System.out.println("result:" + s.peek());
    }

    static class Stack<Item> {
        private int N = 0;
        private Item[] a;

        public Stack(int cap) {
            a = (Item[]) new Object[cap];
        }

        public void push(Item item) {
            a[N++] = item;
        }

        public Item pop() {
            return a[--N];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public Item peek() {
            return a[N - 1];
        }
    }
}
