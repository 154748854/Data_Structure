import binarysearchtree.BinarySearchTree;
import demo1.HashBuck;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,11);
        hashBuck.put(2,22);
        hashBuck.put(19,99);
        hashBuck.put(5,55);
        hashBuck.put(6,66);
        hashBuck.put(7,77);
        hashBuck.put(8,88);
        hashBuck.put(4,44);

        System.out.println(hashBuck.get(9));
    }
    public static void main3(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("hello");
        set.add("the");
        set.add("sunny");

        System.out.println(set);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static void main2(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("sunny",3);
        map.put("the",5);
        map.put("hello",2);

        // get方法是通过key来获取val值
        Integer val = map.get("the");
        System.out.println(val);

        Set<String> set = map.keySet();
        System.out.println(set);

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        for (Map.Entry<String,Integer> entry: entrySet) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        Map<String,Integer> map2 = new HashMap<>();
    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,12,3,2,11,15};

        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
    }


}
