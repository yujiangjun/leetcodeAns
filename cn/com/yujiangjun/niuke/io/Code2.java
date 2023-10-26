package cn.com.yujiangjun.niuke.io;

import java.util.Scanner;

public class Code2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            int num = s.nextInt();
            int sum=0;
            for (int i = 0; i < num; i++) {
                sum+=s.nextInt();
            }
            System.out.println(sum);
        }
    }
}
