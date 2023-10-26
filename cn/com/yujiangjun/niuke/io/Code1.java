package cn.com.yujiangjun.niuke.io;

import java.util.Scanner;

public class Code1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            int col = scanner.nextInt();
            int sum=0;
            for (int j = 0; j < col; j++) {
                sum+=scanner.nextInt();
            }
            System.out.println(sum);
        }
    }

}
