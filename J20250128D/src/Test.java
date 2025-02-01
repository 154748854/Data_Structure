import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Imp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        //01 和 02 进行比较,小根堆
        return o1.compareTo(o2);
    }
}
public class Test {

    public int[] smallestK(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Imp());

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            int top = priorityQueue.peek();
            if(array[i] < top) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] array = {10,3,15,7,19,9};

        //相当于以向上调整的方式建立小根堆
        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]);
        }

        int k = 3;
        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }

        System.out.println(Arrays.toString(ret));

    }
    public static void main3(String[] args) {
        Imp imp = new Imp();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(imp);
        priorityQueue.offer(5);
        priorityQueue.offer(6);
        priorityQueue.offer(10);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.initElem(array);

        testHeap.createHeap();
        //testHeap.pop();
    }


    public
}
