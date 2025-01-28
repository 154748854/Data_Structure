public class Test2 {
    public static void main(String[] args) {
        int usedSize = 10;
        System.out.println(usedSize);
        fun1(usedSize--);
        fun1(usedSize--);
        System.out.println(usedSize);
    }

    public static void fun1(int i) {
        System.out.println();
    }
}

