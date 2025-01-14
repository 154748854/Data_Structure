public class Test {
    public static void main(String[] args) {

    }
    //合并两个有序链表
    public static MySingleList.ListNode twoLists(MySingleList.ListNode head1,
                                          MySingleList.ListNode head2) {
        MySingleList.ListNode newH = new MySingleList.ListNode(-1);
        MySingleList.ListNode tmpH = newH;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tmpH.next = head1;
                head1 = head1.next;
            }else {
                tmpH.next = head2;
                head2 = head2.next;
            }
            tmpH = tmpH.next;
        }
        if (head1 != null) {
            tmpH.next = head1;
        }
        if (head2 != null) {
            tmpH.next = head2;
        }

        return newH.next;
        //newH的next就是新列表的头结点
    }

    public static void main2(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.addLast(67);
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(12);
        mySingleList2.addLast(24);
        mySingleList2.addLast(28);
        mySingleList2.addLast(29);
        mySingleList2.addLast(30);
        mySingleList2.addLast(167);

        MySingleList.ListNode head = twoLists(mySingleList.head, mySingleList2.head);

    }


    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.createNode();

        mySingleList.display();
        System.out.println(mySingleList.size());
        System.out.println(mySingleList.contains(1156));
    }
}
