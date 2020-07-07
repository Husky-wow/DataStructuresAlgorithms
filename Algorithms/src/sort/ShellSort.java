package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSortWithExchange(array);
    }


    /**
     * 希尔排序 - 交换法
     *  思路总结:
     *    1. 第一层for循环，将数组分成gap个子数组，每个数组中的元素为 gap /= 2，直至gap = 1;
     *    2. 第二层for循环，依次排序每个子数组；
     *    3. 第三层for循环，从后向前，比较子数组中的每个元素，将大数向后移（升序）；
     * @param array
     */
    public static void shellSortWithExchange(int[] array) {

        for (int gap = array.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
        }



    }

}
