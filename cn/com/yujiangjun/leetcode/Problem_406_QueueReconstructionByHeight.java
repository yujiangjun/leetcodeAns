package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_406_QueueReconstructionByHeight {

    public static class Unit {
        public int h;
        public int k;

        public Unit(int height, int greater) {
            h = height;
            k = greater;
        }
    }

    public static class UnitComparator implements Comparator<Unit> {

        @Override
        public int compare(Unit o1, Unit o2) {
            return o1.h != o2.h ? (o2.h - o1.h) : (o1.k - o2.k);
        }

    }

    public static int[][] reconstructQueue1(int[][] people) {
        int N = people.length;
        Unit[] units = new Unit[N];
        for (int i = 0; i < N; i++) {
            units[i] = new Unit(people[i][0], people[i][1]);
        }
        Arrays.sort(units, new UnitComparator());
        ArrayList<Unit> arrList = new ArrayList<>();
        for (Unit unit : units) {
            arrList.add(unit.k, unit);
        }
        int[][] ans = new int[N][2];
        int index = 0;
        for (Unit unit : arrList) {
            ans[index][0] = unit.h;
            ans[index++][1] = unit.k;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] people={
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        reconstructQueue1(people);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1,1);
//        list.add(1,2);
//        System.out.println(list.toArray());
    }
}
