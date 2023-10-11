package cn.com.yujiangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0076_MinimumWindowSubstring {


    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> coverMap = new HashMap<>();
        Map<Character, Integer> sc = new HashMap<>();

        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
            coverMap.put(c, false);
        }
        int min = Integer.MAX_VALUE;

        int ansl = 0;
        int ansr = 0;
        char[] str = s.toCharArray();
        int l = 0;
        for (int r = 0; r < str.length; r++) {
            sc.put(str[r], sc.getOrDefault(str[r], 0) + 1);
            if (counter.containsKey(str[r]) && sc.get(str[r]) >= counter.get(str[r])) {
                coverMap.put(str[r], true);
            }
            while (l <= r && isCover(coverMap)) {
                if (min > (r - l + 1)) {
                    ansl = l;
                    ansr = r;
                    min = r - l + 1;
                }
                sc.put(str[l], sc.get(str[l]) - 1);
                if (counter.containsKey(str[l]) && sc.get(str[l]) < counter.get(str[l])) {
                    coverMap.put(str[l], false);
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : String.valueOf(str, ansl, min);
    }

    public static String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Integer> sc = new HashMap<>();

        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;

        int ansl = 0;
        int ansr = 0;
        char[] str = s.toCharArray();
        int l = 0;
        for (int r = 0; r < str.length; r++) {
            sc.put(str[r], sc.getOrDefault(str[r], 0) + 1);
            if (counter.containsKey(str[r]) && sc.get(str[r]) >= counter.get(str[r])) {
                counter.remove(str[r]);
            }
            while (l <= r && counter.isEmpty()) {
                if (min > (r - l + 1)) {
                    ansl = l;
                    ansr = r;
                    min = r - l + 1;
                }
                sc.put(str[l], sc.get(str[l]) - 1);
                if (t.indexOf(str[l]) > 0) {
                    counter.put(str[l], counter.getOrDefault(str[l], 0) + 1);
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : String.valueOf(str, ansl, min);
    }

    public static boolean isCover(Map<Character, Boolean> coverMap) {
        for (Character key : coverMap.keySet()) {
            if (!coverMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println("==============");
        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow(s2, t2));
        System.out.println("==============");
        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow(s3, t3));
        System.out.println("==============");

        String s4 = "a";
        String t4 = "b";
        System.out.println(minWindow(s4, t4));
        System.out.println("==============");
    }
}
