package 一_基础算法.a2_归并排序;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @user: Hasee
 * @date: 2021/2/10 22:48
 * @author: 1931559710@qq.com
 * ClassName: reverse_order_pairs
 * Description:
 * 给定一个长度为n的整数数列，请你计算数列中的逆序对的数量。
 * <p>
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 输入格式
 * 第一行包含整数n，表示数列的长度。
 * <p>
 * 第二行包含 n 个整数，表示整个数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 * <p>
 * 数据范围
 * 1≤n≤100000
 */
public class reverse_order_pairs {
    private static int[] brr;
    private static long num = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        brr = new int[n];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int b = scanner.nextInt();
            arr.add(b);
        }
        mergeSort(arr, 0, n - 1);
        System.out.println(num);
    }

    private static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = mid + 1, k = 0;
        //开始两个归并段内部排序
        //low为第一个有序区元素，high为第二个有序区的最后一个元素，mid为第一个有序区的最后一个元素
        while (i <= mid && j <= high) {
            if (arr.get(i) > arr.get(j)) {
                num += mid - i + 1;
            }
            //如果arr[i] <= arr[j],则不构成逆序对,i++ （注意=时也是i走，否则会漏掉一个j！）
            brr[k++] = arr.get(i) <= arr.get(j) ? arr.get(i++) : arr.get(j++);
        }
        //把剩余没有检测完的序列直接全部复制到arr中
        while (i <= mid) {
            brr[k++] = arr.get(i++);
        }
        while (j <= high) {
            brr[k++] = arr.get(j++);
        }
        for (int m = low, p = 0; m <= high; m++, p++) {
            arr.set(m, brr[p]);
        }
    }

    private static void mergeSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            //从中间划分出两个子序列
            int mid = (low + high) >> 1;
            //对左侧子序列进行递归排序
            mergeSort(arr, low, mid);
            //对右侧子序列进行递归排序
            mergeSort(arr, mid + 1, high);
            //用于归并
            merge(arr, low, mid, high);
        }
    }
}
