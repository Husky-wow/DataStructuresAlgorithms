package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author admin
 * @ClassName QuickSork.java
 * @Description 快速排序。递归、分治思想
 * @createTime 2020年07月09日 00:22:00
 */
public class QuickSork {

    static int dataNum = 8000000;

    public static void main(String[] args) {
        /*int[] array = {21, 25, 49, 25, 16, 8, 21};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));*/

        int[] arr = new int[dataNum];
        for (int i = 0; i < dataNum; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date1));

        quickSort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date2));
        //System.out.println(Arrays.toString(arr));


    }


    private static void quickSort(int[] array, int low, int high) {
        // 结束递归的条件是 low >= high
        if (low < high) {
            // 找出枢轴位置
            int pivotIndex = findPivoteIndex(array, low, high);
            // 对左边子部分排序
            quickSort(array, low, pivotIndex - 1);
            // 对右边子部分排序
            quickSort(array, pivotIndex + 1, high);
        }


    }

    /**
     * 找到枢轴点位置索引
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int findPivoteIndex(int[] array, int low, int high) {
        // 选定位置索引low处值为枢轴值
        int pivot = array[low];
        /*
        循环遍历数组，直到low == high时停止，
        找到比枢轴值大的数放在枢轴值的右边；
        找到比枢轴值小的数放在枢轴值的左边
         */
        while (low < high) {
            // 因为最开始选定low位置为枢轴值，所以从high开始找
            while (low < high && array[high] >= pivot) {
                high --;
            }
            // 执行到此句，表示找到 array[high] < pivot 或者 low == high 处
            array[low] = array[high];

            while (low < high && array[low] <= pivot) {
                low ++;
            }
            array[high] = array[low];
        }

        // 执行到此处为low == high，此时该位置为枢轴位置，将枢轴值放置在该位置，并返回该位置
        array[low] = pivot;
        return low;
    }


}
