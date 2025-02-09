import binarysearchtree.BinarySearchTree;
import demo1.HashBuck;
import demo1.HashBuck2;

import java.util.*;

class Student {
    public String id;
    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("12345");
        Student student2 = new Student("12345");
        HashBuck2<Student,Integer> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(student1,10);
        System.out.println(hashBuck2.getValue(student2));
    }

    public static void main6(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("abcd",10);
        hashMap.put("gao",3);
        hashMap.put("hello",2);

        Integer i = hashMap.get("abcd");
        System.out.println(i);
        System.out.println(hashMap);
        for (Map.Entry<String,Integer> entry:hashMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //不支持迭代器遍历
    }
    public static void main4(String[] args) {
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

class TestB {
    public List<String> topKFrequent(String[] words, int k) {
        //1. 先统计单词出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word:words) {
            if(map.get(word) == null) {
                map.put(word,1);
            }else {
                int val = map.get(word);
                map.put(word,val+1);
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });





    }





}
