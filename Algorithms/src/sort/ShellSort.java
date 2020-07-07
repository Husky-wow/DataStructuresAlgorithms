package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 *
 * 思路总结:
 *      1. 第一层for循环，将数组分成若干个子数组，每个子数组元素个数为gap,每轮gap均发生变化gap /= 2，直至gap = 1;
 *      2. 第二层for循环，从下标为gap的元素依次向后遍历；
 *      3. 第三层for循环，从后向前，比较该元素和前边所有子数组中同样位置的元素大小，插入排序；
 *      其实，第2步和第2步组合起来看：就是将每个子数组中同样位置索引的元素组成一个数组，然后对该数组使用插入排序
 *      插入排序是从数组的第二个元素开始，此处就是从原始数组的第gap个元素开始
 */
public class ShellSort {
    static int dataNum = 80000;
    public static void main(String[] args) {
        //int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        /*
        生成一个8 w个随机数的数组
         */
        int[] arr = new int[dataNum];
        for (int i = 0; i < dataNum; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date1));

        shellSortWithExchange(arr);
        //shellSortWithInsert(arr);

        Date date2 = new Date();
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date2));
        System.out.println(Arrays.toString(arr));



        //System.out.println(Arrays.toString(array));

    }


    /**
     * 希尔排序 - 交换法
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
            //System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 希尔排序 - 插入法（移位法）
     * @param array
     */
    public static void shellSortWithInsert(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int min = array[i];
                for (; j - gap >= 0 ; j -= gap) {
                    if (array[j - gap] > min) {
                        array[j] = array[j - gap];
                    } else {
                        break;
                    }
                }
                if (j != i) {
                    array[j] = min;
                }
            }
            //System.out.println(Arrays.toString(array));
        }
    }

}
