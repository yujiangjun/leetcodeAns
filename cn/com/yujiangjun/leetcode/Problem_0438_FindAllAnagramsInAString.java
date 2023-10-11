package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0438_FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
            return ans;
        }
        Map<Character, Integer> pmap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            process(s.toCharArray(), p.toCharArray(), i, pmap, ans);
        }
        return ans;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
            return ans;
        }
        char[] ptr = p.toCharArray();
        int pn = ptr.length;
        int[] scount = new int[26];
        int[] pcount = new int[26];

        for (char c : ptr) {
            pcount[c - 'a']++;
        }
        char[] str = s.toCharArray();
        int index = 0;
        for (; index < pn; index++) {
            scount[str[index] - 'a']++;
        }

        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }
        for (int i = 0; i + pn < str.length; i++) {
            scount[str[i + pn] - 'a']++;
            scount[str[i] - 'a']--;
            if (Arrays.equals(pcount, scount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
            return ans;
        }
        int[] count = new int[26];
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int diff = 0;
        for (int i = 0; i < ptr.length; i++) {
            count[str[i] - 'a']++;
            count[ptr[i] - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i = 0; i + ptr.length < str.length; i++) {
            if (count[str[i] - 'a'] == 1) {
                diff--;
            } else if (count[str[i] - 'a'] == 0) {
                diff++;
            }
            count[str[i] - 'a']--;
            if (count[str[i + ptr.length] - 'a'] == -1) {
                diff--;
            } else if (count[str[i + ptr.length] - 'a'] == 0) {
                diff++;
            }
            count[str[i + ptr.length] - 'a']++;
            if (diff == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static boolean isSame(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character c : map1.keySet()) {
            if (!map2.containsKey(c)) {
                return false;
            }
            Integer val1 = map1.get(c);
            if (val1 != map2.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void process(char[] str, char[] ptr, int i, Map<Character, Integer> pMap, List<Integer> path) {
        if (pMap.isEmpty()) {
            path.add(i - ptr.length);
            return;
        }
        if (i == str.length) {
            return;
        }
        if (!pMap.containsKey(str[i])) {
            return;
        }
        Integer count = pMap.get(str[i]);
        count--;
        if (count == 0) {
            pMap.remove(str[i]);
        } else {
            pMap.put(str[i], count);
        }
        process(str, ptr, i + 1, pMap, path);
        if (count == 0) {
            pMap.put(str[i], 0);
        }
        count++;
        pMap.put(str[i], count);
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(Arrays.toString(findAnagrams(s1, p1).toArray()));
        System.out.println(Arrays.toString(findAnagrams2(s1, p1).toArray()));
        System.out.println(Arrays.toString(findAnagrams3(s1, p1).toArray()));
        System.out.println("=================");
    }
}
