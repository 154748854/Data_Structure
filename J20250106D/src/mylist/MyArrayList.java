package mylist;

import java.util.Arrays;

public class MyArrayList implements IList{
    private int[] elem;
    private int usedSize;
    //顺序表的默认大小
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     *  遍历顺序表当中的元素
     */
    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i]+" ");
        }
        System.out.println();
    }
    private void checkCapacity() {
        //为什么使用private，是因为这个check是为当前类当中的方法进行服务的，并不是给客户去使用的
        //客户能check个啥
        if(isFull()) {
            //扩容
            elem = Arrays.copyOf(elem,elem.length*2);
        }
    }
    @Override
    public void add(int data) {
        checkCapacity();
        this.elem[this.usedSize] = data;
        this.usedSize++;

    }

    @Override
    public boolean isFull() {
        return this.usedSize == elem.length;
    }

    @Override
    public void add(int pos, int data) {
        try {
            checkPosOnAdd(pos);
        }catch (PosIllegal e) {
            e.printStackTrace();
            return;
        }
        checkCapacity();

        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }

    /**
     * 检查pos的合法性
     * @param pos
     */
    private  void checkPosOnAdd(int pos) throws PosIllegal{
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("不合法");
            throw new PosIllegal("插入元素下标异常"+pos);
        }
    }
    @Override
    public boolean contains(int toFind) {
        if(isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            //如果是查找引用数据类型 一定记住，要重写方法。
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }

    @Override
    public int indexOf(int toFind) {
        if(isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            //如果是查找引用数据类型 一定记住，要重写方法。
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) throws Empty{
        checkPosOnGet(pos);
        if(isEmpty()) {
            throw new Empty("获取指定元素下标时 顺序表为空"+pos);
        }
        return this.elem[pos];
    }
    private  void checkPosOnGet(int pos) throws PosIllegal{
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("不合法");
            throw new PosIllegal("获取指定元素下标异常"+pos);
        }
    }

    @Override
    public void set(int pos, int value) {

    }

    @Override
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if(index == -1) return;
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

}
