import java.util.List;

public class MySingleList implements IList {
    //节点的内部类
    static class ListNode {
        //为什么是内部类，因为它有很多成员
        //静态内部类是不需要通过外部类的对象引用获得
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

    }
    //为什么不写到内部类中，是因为head是链表的成员而不是节点的成员
    public ListNode head;
    public void createNode() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;
    }
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head != null) {
            node.next = head;
        }
        this.head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null) {
            this.head = node;
        }else {
            //找到尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            //cur执行最后一个节点
            cur.next = node;
        }

    }

    @Override
    public void addIndex(int index, int data) {
        if(index < 0 || index > size()) {
            //抛一个自定义异常
            return;
        }

    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }else cur = cur.next;
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
        int size = 0;
        ListNode cur = this.head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {
        //为了防止head因为遍历而被改变，我们选择使用cur代替head
        ListNode cur = this.head;
        while (cur != null) {
            System.out.println(cur.val+" ");
            cur = cur.next;
        }
    }
}
