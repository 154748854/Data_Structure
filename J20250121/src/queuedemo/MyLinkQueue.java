package queuedemo;

public class MyLinkQueue {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;

        }
    }

    public ListNode head;
    public ListNode last;
    public int usedSize;
    public boolean offer(int val) {
        ListNode node = new ListNode(val);
        if(this.head == null) {
            head = node;
        }else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        usedSize++;
        return true;
    }

    public int poll() {
        if(this.head == null) {
            usedSize--;
            return -1;
        }
        if(head.next == null) {
            int retVal = head.val;
            head = null;
            last = null;
            usedSize--;
            return retVal;
        }

        int val = head.val;
        head = head.next;
        head.prev = null;
        usedSize--;
        return val;
        //这是选择结构，而且方法遇到return就会结束，所以这样写；
    }

    public int peek() {
        if(this.head == null) {
            return -1;
        }
        return head.val;
    }

    public boolean empty() {
        return this.head == null;
    }

    public int size() {
        return usedSize;
    }
}
