//class MyArray {
//    Object[] array = new Object[10];
//    public void setValue(int pos, Object val) {
//        array[pos] = val;
//    }
//    public Object getValue(int pos) {
//        return array[pos];
//    }
//}

/**
 *
 * @param <T>当前类是一个泛型类，他只是一个占位符
 */
class MyArray <T> {
    //Object[] T = new T[10];
    public Object[] array = new Object[10];
    public void setValue(int pos, T val) {
        array[pos] = val;
    }
    public T getValue(int pos) {
        return (T)array[pos];//把返回的类型强转为指定类型
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyArray<Integer> myArray1 = new MyArray<Integer>();
        myArray1.setValue(0,10);
        myArray1.setValue(1,100);

        int a = myArray1.getValue(1);
        System.out.println(a);

        MyArray<String> myArray2 = new MyArray<String>();
        myArray2.setValue(0,"abcd");
        myArray2.setValue(1,"efg");
        String ret = myArray2.getValue(1);
        System.out.println(ret);
    }
}
