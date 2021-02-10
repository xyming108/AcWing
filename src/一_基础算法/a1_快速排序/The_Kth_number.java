package 一_基础算法.a1_快速排序;

import java.util.Scanner;

/**
 * @user: Hasee
 * @date: 2021/2/10 14:09
 * @author: 1931559710@qq.com
 * ClassName: The_Kth_number
 * Description:
 * 给定一个长度为n的整数数列，以及一个整数k，请用快速选择算法求出数列从小到大排序后的第k个数。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 * <p>
 * 第二行包含 n 个整数（所有整数均在1~109范围内），表示整数数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示数列的第k小数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 */
public class The_Kth_number {
    //内部类要加static
    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            //将比pivot小的元素移动到左边
            while (pivot <= a[high] && low < high) high--;
            a[low] = a[high];
            //将比pivot大的元素移动到右边
            while (pivot >= a[low] && low < high) low++;
            a[high] = a[low];
        }
        a[low] = pivot; //枢纽元素放到最终位置
        return low; //返回存放枢纽元素的最终位置下标
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotPos = partition(a, low, high); //获取枢纽元素的位置下标
            //开始从枢纽元素的两边分别递归排序（分治）
            quickSort(a, low, pivotPos - 1);
            quickSort(a, pivotPos + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        quickSort(a, 0, a.length - 1);

        System.out.println(a[k - 1]);
    }
}