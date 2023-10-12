package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0030_SubstringWithConcatenationOfAllWords {


    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int n = words.length;
        int width = n * wordLen;
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        char[] str = s.toCharArray();
        int l=0;
        for (int r = 0; r < str.length; r++) {

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(Arrays.toString(findSubstring(s, words).toArray()));
        System.out.println("===================");
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println(Arrays.toString(findSubstring(s2, words2).toArray()));
        System.out.println("===================");
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println(Arrays.toString(findSubstring(s3, words3).toArray()));
        System.out.println("===================");
        String s4 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words4 = {"fooo", "barr", "wing", "ding", "wing"};
        System.out.println(Arrays.toString(findSubstring(s4, words4).toArray()));
        System.out.println("===================");

    }
}
