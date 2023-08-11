package cn.com.yujiangjun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q277_FindCelebrity {

    private static int[][] data;

    public static int findCelebrity(int n) {
        // 不是名人的数据
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (knows(j, i)) {
                        set.add(j);
                    } else if (knows(i, j)) {
                        set.add(i);
                    }else if (!knows(i,j)&&!knows(j,i)){
                        set.add(i);
                        set.add(j);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    static boolean knows(int a, int b) {
        return data[a][b] == 1;
    }

    public static void main(String[] args) {
        data = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println(findCelebrity(3));
        System.out.println("=================");
        data = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(findCelebrity(3));
        System.out.println("=================");
        data = new int[][]{
                {1, 0}, {0, 1}
        };
        System.out.println(findCelebrity(2));
        System.out.println("=================");
    }
}
