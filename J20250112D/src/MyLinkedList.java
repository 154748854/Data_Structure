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
        //检查index的合法性
        int len = size();
        if(index < 0 || index > len) {
            System.out.println("不合法");
            //抛异常
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == len){
            addLast(data);
            return;
        }
        ListNode cur = findIndex(index);
        ListNode node  = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private ListNode findIndex(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
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
        //一个对象只要不被引用就会被销毁了
        //和它引不引用别人没有关系
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    //如果为空，head == null就已经删完了
                    if (head != null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;

                    if(cur.next == null) {
                        last = last.prev;
                    }else{
                        cur.next.prev = cur.prev;
                    }
                }
                return;
            }else cur = cur.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        //一个对象只要不被引用就会被销毁了
        //和它引不引用别人没有关系
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    //如果为空，head == null就已经删完了
                    if (head != null) {
                        last = null;
                    }else {
                        head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;

                    if(cur.next == null) {
                        last = last.prev;
                    }else{
                        cur.next.prev = cur.prev;
                    }
                }
            }else cur = cur.next;
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
        last = null;
        //注意如果直接暴力将head 和
    }
}
