import java.util.Arrays;

public class TestHeap {
    private int[] elem;
    public int usedSize;//记录当前堆当中有效的数据个数

    public TestHeap() {
        this.elem = new int[10];
    }


    /**
     * 初始化elem数组的
     * @param array
     */
    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }


    /**
     * 创建大根堆的代码
     */
    public void createHeap() {
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            siftDown(parent, usedSize);
        }
    }

    /**
     * 向下调整
     * @param parent
     * @param len
     */
    private void siftDown(int parent, int len) {
        int child = 2*parent + 1;
        //while 条件，至少有左孩子
        while (child < len) {
            // 左条件为真说明一定有右孩子
            // 左孩子 和 右孩子 比较大小, 如果右孩子的值大，那么
            if(child+1 < len && elem[child] < elem[child+1]) {
                child = child + 1;
            }
            // 走完if语句 child存的是左右孩子当中较大的那一个的下标
            if(elem[child] > elem[parent]) {
                swap(elem[child], elem[parent]);
                parent = child;
                child = parent*2 + 1;
            }else {
                break;
            }
        }
    }

    public void push(int val) {
        //满了
        if(isFull()) {
            elem = Arrays.copyOf(elem, elem.length*2);
        }
        elem[usedSize] = val;
        //向上调整
        siftUp(usedSize);
        //
        usedSize++;
    }

    public void siftUp(int child) {
        int parent = (child -1)/2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public void swap(int i, int j) {
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }

    public int pop() {
        if(empty()) return -1;
        int oldVal = elem[0];
        swap(0,usedSize-1);
        usedSize--;
        siftDown(0,usedSize);
        return oldVal;
    }

    public boolean empty() {
        return usedSize == 0;
    }

}
