package cn.com.yujiangjun.niuke;

public class BM20 {

    public static final int kmod = 1000000007;
    public static int ans = 0;

    public static int InversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }


    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);

    }

    public static void merge(int[] num, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (num[i] > num[j]) {
                help[k++] = num[j++];
                ans += (mid - i + 1);
                ans %= kmod;
            } else {
                help[k++] = num[i++];
            }
        }
        while (i <= mid) {
            help[k++] = num[i++];
        }
        while (j <= r) {
            help[k++] = num[j++];
        }
        for (k = 0, i = l; i <= r; ++i, ++k) {
            num[i] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
        int[] arr2 = {1, 2, 3};
        System.out.println(InversePairs(arr2));
    }
}
