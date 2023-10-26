package cn.com.yujiangjun.niuke.io;

import java.util.Arrays;
import java.util.Scanner;

public class Code5 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            String[] str = s.nextLine().split(" ");
            Arrays.sort(str);
            String s1 = String.join(" ", str);
            System.out.println(s1);
        }
    }
}
