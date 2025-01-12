import java.util.List;

public class MyLinkedList implements IList{
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
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;
    }

    @Override
    public void addIndex(int index, int data) {

    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {

    }
}
