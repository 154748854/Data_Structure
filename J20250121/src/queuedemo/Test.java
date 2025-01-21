package queuedemo;

public class Test {
    public static void main(String[] args) {
        MyLinkQueue myLinkQueue = new MyLinkQueue();
        myLinkQueue.offer(1);


        System.out.println(myLinkQueue.peek());//1
        System.out.println(myLinkQueue.poll());//1
        System.out.println(myLinkQueue.poll());//2

    }
}
