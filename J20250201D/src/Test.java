import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main2(String[] args) {
        int[] array = new int[1_0000];
        initOrder(array);
        testInsert(array);
        testShell(array);
    }
    public static void norOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }
    public static void testInsert(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();

        Sort.insertSort(tmpArray);

        long endTime = System.currentTimeMillis();

        System.out.println("插入排序 "+(endTime - startTime));
    }

    public static void testShell(int[] array) {
        int[] tmpArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();

        Sort.shellSort(tmpArray);

        long endTime = System.currentTimeMillis();

        System.out.println("希尔排序 "+(endTime - startTime));
    }

    public static void initOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }
    }
    public static void main1(String[] args) {
        int[] array = {1,3,5,5,2,63,6};
        Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {100,3,15,61,17,8,7};
        Sort.mergeSortNor(array);
        System.out.println(Arrays.toString(array));
    }

}
