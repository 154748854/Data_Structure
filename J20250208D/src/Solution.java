import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<String> hashSet = new HashSet<>();
        char[] jewels2 = jewels.toCharArray();
        char[] stones2 = stones.toCharArray();
        int count = 0;
        for (char c : jewels2) {
            for (char x : stones2) {
                if (x == c) {
                    count++;
                }
            }
        }
        return count;
    }
    //我真牛逼 小母牛进了公牛窝 ———— 牛逼炸了
    public int numJewelsInStones2(String jewels, String stones) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char ch: jewels.toCharArray()) {
            hashSet.add(ch);
        }
        int count = 0;
        for (char ch:stones.toCharArray()) {
            if(hashSet.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}