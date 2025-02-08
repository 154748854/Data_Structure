package demo1;

public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;//存放了多少个有效数据
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBuck() {
        array = new Node[10];
    }

    public void put(int key, int val) {
        int index = key % array.length;

        //遍历index下标的链表，是否存在key 存在更新value 不存在进行tou插法
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                //更新val
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        usedSize++;

        if(doLoadFactor() > DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[2*array.length];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            //遍历每个数组元素
            while (cur != null) {
                Node tmp = cur.next;
                int newIndex = cur.key % newArray.length;//新的数组下标
                //采用头插法 插入新数组的index下标
                //先绑后面
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = tmp;
            }
        }

        array = newArray;
    }

    private float doLoadFactor() {
        return usedSize*1.0f / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[key];
        //遍历每个数组元素
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

}
