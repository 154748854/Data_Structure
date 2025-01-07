import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        List<List<Integer>> list3 = new ArrayList<>();
        list3.add(new ArrayList<>());

    }
    public static void main1(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        list.add(0,99);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+" ");
        }
        System.out.println();
        ArrayList<Integer> list12 = new ArrayList<>(list);
//        System.out.println(list);
    }
}
