package hackerrank;

public class QueuesATaleofTwoStacks {
    public static class MyQueue<E> {
        private int max = 10000000;
        private int ptr = 0;
        private int deQueuePtr = 0;
        private E[] arr = (E[]) new Object[max];

        public E enqueue(E item) {
            arr[ptr] = item;
            ptr++;
            return item;
        }

        public void dequeue() {
            if(ptr <= deQueuePtr){
                return;
            }

            arr[deQueuePtr] = null;
            deQueuePtr++;
        }

        public E peek() {
            return arr[deQueuePtr];
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        int n = 8;
        //int[] arr = {1, 2, 3, 1, 2, 3, 2, 3};
        int[] arr = {1, 2, 3, 2, 2, 2, 2, 2};
        int[] numArr = {15, 17, 25, 0, 0, 0, 0};

        for (int i = 0; i < n; i++) {
            int operation = arr[i];
            if (operation == 1) { // enqueue
                queue.enqueue(numArr[i]);
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }

    }
}
