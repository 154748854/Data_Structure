import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
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
}
