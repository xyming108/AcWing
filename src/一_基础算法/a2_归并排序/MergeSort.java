package 一_基础算法.a2_归并排序;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @user: Hasee
 * @date: 2021/2/10 16:57
 * @author: 1931559710@qq.com
 * ClassName: MergeSort
 * Description:
 * 给定你一个长度为n的整数数列。
 * <p>
 * 请你使用归并排序对这个数列按照从小到大进行排序。
 * <p>
 * 并将排好序的数列按顺序输出。
 * <p>
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 * <p>
 * 第二行包含 n 个整数（所有整数均在1~109范围内），表示整个数列。
 * <p>
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 */
public class MergeSort {

    private static int[] brr;

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
        for (int j = 0; j < n; j++) {
            System.out.println(arr.get(j) + " ");
        }
    }

    private static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = mid + 1, k = 0;
        //开始两个归并段内部排序
        //low为第一个有序区元素，high为第二个有序区的最后一个元素，mid为第一个有序区的最后一个元素
        while (i <= mid && j <= high) {
            brr[k++] = arr.get(i) < arr.get(j) ? arr.get(i++) : arr.get(j++);
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