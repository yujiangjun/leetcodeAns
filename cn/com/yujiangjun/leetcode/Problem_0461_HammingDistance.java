package cn.com.yujiangjun.leetcode;

public class Problem_0461_HammingDistance {


    public static int hammingDistance(int x,int y){
        int t=x^y;
        int count=0;
        while (t!=0){
            count+=(t&1);
            t>>=1;
        }
        return count;
    }
}
