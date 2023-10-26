package cn.com.yujiangjun.niuke.io;

import java.util.Scanner;

public class Code3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            int sum=0;
            String[] s1 = s.nextLine().split(" ");
            for (int i = 0; i < s1.length; i++) {
                sum+=Integer.parseInt(s1[i]);
            }
            System.out.println(sum);
        }
    }
}
