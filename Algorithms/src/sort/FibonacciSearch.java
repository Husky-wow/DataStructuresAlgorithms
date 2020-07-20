package sort;

import java.util.Arrays;

/**
 * 斐波那契搜索,原理见笔记
 *  注意，仍然要使用有序数组
 * @author xuyifan
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 100, 123, 140, 150, 160, 170, 188, 200, 1000};
        int index = fibonacciSearch(array, 1000);
        System.out.println(index);
    }

    /**
     * 获取一个长度为20的斐波那契数组
     * @return
     */
    private static int[] getFibonacciArray() {
        int[] array = new int[20];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }



        return array;
    }

    private static int fibonacciSearch(int[] array, int targetValue) {

        int low = 0;
        int high = array.length - 1;
        // 获取斐波那契数组
        int[] fibonacciArr = getFibonacciArray();
        // 斐波那契索引值
        int k = 0;
        /*
        寻找f[k]
         */
        while (array.length > fibonacciArr[k]) {
            k++;
        }
        // 按照fibonacciArr[k]将数组赋值，因为fibonacciArr[k]可能>array.length
        int[] tempArray = Arrays.copyOf(array, fibonacciArr[k]);
        if (array.length < tempArray.length) {
            /*
            填充多余处的位置
             */
            for (int i = array.length; i < tempArray.length; i++) {
                tempArray[i] = array[array.length - 1];
            }
        }

        /*
        循环搜索
         */
        while (low <= high) {
            /*
            计算mid，判断k - 1的值，因为有时候寻找几轮后，k < 1, 此时 k - 1 为负数，数组越界
             */
            int key = k - 1;
            if (key < 0) {
                key = 0;
            }
            int mid = low + fibonacciArr[key] - 1;

            if (targetValue < tempArray[mid]) {
                // 向左寻找
                high = mid - 1;
                /*
                为什么是k -= 1?
                1. 因为首先将原始数组分为f[k - 1]和f[k - 2]两个部分，f[k -1]为左半部分；
                2. targetValue < array[mid]，要向左边部分继续寻找；
                3. 所以将f[k-1]继续拆分为f[k - 1 - 1] + f[k - 1 - 2]两部分，并且以f[k - 1 - 1]来计算mid
                 */
                k -= 1;
            } else if (targetValue > tempArray[mid]) {
                // 向右寻找
                low = mid + 1;
                /*
                为什么是k -= 2？
                1. 因为首先将原始数组分为f[k - 1]和f[k - 2]两个部分，f[k -2]为右半部分；
                2. targetValue > array[mid]，要向右边部分继续寻找；
                3. 所以将f[k-1]继续拆分为f[k - 2 - 1] + f[k - 2 - 2]两部分，并且以f[k - 2 - 1]来计算mid
                品，细品
                 */
                k -= 2;
            } else {
                if (mid > high) {
                    return high;
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }

}
