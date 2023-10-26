package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0769_MaxChunksToMakeSorted {


    public static int maxChunksToSorted(int[] arr) {
        // 栈顶到栈底从大到小
        Stack<Integer> ans = new Stack<>();
        int n = arr.length;
        ans.add(0);
        for (int i = 1; i < n; i++) {
            // cur大于栈顶，表示找到一个分段了
            if (!ans.isEmpty() && arr[ans.peek()] < arr[i]) {
                ans.push(i);
                continue;
            }
            // 抓取栈顶元素，即最大元素
            int max = ans.peek();
            // 把栈中所有比cur大的数弹出，然后再讲最大值保存
            while (!ans.isEmpty() && arr[ans.peek()] > arr[i]) {
                ans.pop();
            }
            ans.push(max);
        }

        return ans.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1, 0};
        System.out.println(maxChunksToSorted(arr1));
        System.out.println("===========");
        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(arr2));
        System.out.println("===========");
        int[] arr3 = {2, 1, 3, 5, 4};
        System.out.println(maxChunksToSorted(arr3));
        System.out.println("===========");
        int[] arr4 = {2, 0, 1};
        System.out.println(maxChunksToSorted(arr4));
        System.out.println("===========");

        int[] arr5 = {0, 1};
        System.out.println(maxChunksToSorted(arr5));
        System.out.println("===========");
    }
}
