package cn.com.yujiangjun.niuke;

import java.util.Random;

public class BM47 {


    public static int findKth(int[] a, int n, int K) {
        if (n == 0) {
            return -1;
        }
        // write code here
        randomizedSelect(a, 0, n - 1, K);
        return a[K - 1];
    }


    public static void randomizedSelect(int[] arr, int l, int r, int k) {
        if (r <= l) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (num == k) {
            return;
        }
        if (k > num) {
            randomizedSelect(arr, pos + 1, r, k - num);
        } else {
            randomizedSelect(arr, l, pos - 1, k);
        }
    }

    private static int randomizedPartition(int[] arr, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, i);
        return partition(arr, l, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int p = arr[l];
        int j = r + 1;
        for (int i = r; i > 0; i--) {
            if (arr[i] < p) {
                j--;
                swap(arr, i, j);
            }
        }
        swap(arr, j - 1, l);
        return j - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        int n = 5;
        int k = 3;
        System.out.println(findKth(arr, n, k));

        int[] arr2 = {10,10,9,9,8,7,5,6,4,3,4,2};
        int n2 = 12;
        int k2 = 3;
        System.out.println(findKth(arr2, n2, k2));
    }
}
