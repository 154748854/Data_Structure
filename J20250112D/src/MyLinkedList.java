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
        if(index < 0 || index > size()) {
            //抛出一个异常
            return;
        }
        ListNode cur = this.head;
        int count = 0;
        while (count != index) {
            cur = cur.next;
            count++;
        }
        //此时cur就在需要替换的位置
        ListNode last = cur.prev;
        ListNode add = new ListNode(data);
        add.next = cur;
        add.prev = last;
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
        ListNode cur = this.head;
        ListNode curNext = cur.next;
        for (int i = 0; i < size(); i++) {
            cur.prev = null;
            cur.next = null;
            cur = curNext;
            if(cur.next != null)
            {
                curNext = curNext.next;
            }
        }
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) return;
        ListNode cur = this.head;
        ListNode prev = this.head;
        ListNode next = this.head;
        while (cur.next != null) {
            next = cur.next;
            prev = cur.prev;
            if(cur.val == key) {
                cur.next = null;
                cur.prev = null;
                prev.next = next;
                next.prev = prev;
                cur = next;

            }else {
                prev = prev.next;

                cur = cur.next;
            }
            next = next.next;
        }
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
        ListNode cur = head;
        while (cur.next != null) {
            ListNode curNext = cur.next;

            cur.next = null;
            cur.prev = null;
            cur = curNext;
        }
        head = null;
    }
}
