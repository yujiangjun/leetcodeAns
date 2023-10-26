package cn.com.yujiangjun.niuke.io;

import java.util.Arrays;
import java.util.Scanner;

public class Code4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String[] str = s.nextLine().split(" ");
        Arrays.sort(str);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println(str[str.length - 1]);
    }
}
