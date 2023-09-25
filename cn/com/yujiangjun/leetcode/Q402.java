package cn.com.yujiangjun.leetcode;

import java.util.Objects;
import java.util.Stack;

public class Q402 {

    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        char[] str = num.toCharArray();
        for (int i = 0; i < str.length && count < k; i++) {
            while (!stack.isEmpty() && str[stack.peek()] > str[i] && count < k) {
                int index = stack.pop();
                str[index] = Character.MAX_VALUE;
                count++;
            }
            stack.push(i);
        }

        while (!stack.isEmpty() && count < k) {
            str[stack.pop()] = Character.MAX_VALUE;
            count++;
        }
        String ans = deletePreZero(str);
        return Objects.equals("", ans) ? "0" : ans;
    }


    public static String deletePreZero(char[] str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (c != Character.MAX_VALUE) {
                sb.append(c);
            }
        }
        char[] s = sb.toString().toCharArray();
        int index=0;
        for (int i = 0; i < s.length; i++) {
            index=i;
            if (s[i] != '0') {
                break;
            }
        }
        sb.delete(0,index);
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "112";
        int k1 = 1;
        System.out.println(removeKdigits(num1, k1));
        System.out.println("============");

    }

//    public static void main(String[] args) {
//        StringBuilder sb=new StringBuilder("12");
//        deletePreZero(sb);
//        System.out.println(sb.toString());
//    }
}
