package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0030_SubstringWithConcatenationOfAllWords {


    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int n = words.length;
        int width = n * wordLen;
        int[] counter = new int[26];
        int[] sc = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counter[c - 'a']++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        int l = 0;
        int r = 0;
        for (; r < str.length; r++) {
            sc[str[r] - 'a']++;
            while (r - l + 1 >= width && isCover(counter, sc)) {
                ans.add(l);
                for (int i = 0; i < wordLen; i++) {
                    sc[str[l+i] - 'a']--;
                    l++;
                }
            }
        }
        if (r - l + 1 >= width && isCover(counter, sc)) {
            ans.add(l);
        }
        return ans;
    }

    public static boolean isCover(int[] counter, int[] sc) {
        for (int i = 0; i < counter.length; i++) {
            if (sc[i] < counter[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(Arrays.toString(findSubstring(s, words).toArray()));
    }
}
