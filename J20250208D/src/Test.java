import binarysearchtree.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {

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
