package sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author xuyifan
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = {614, 738, 921, 485, 637, 101, 215, 530, 790, 306};
        System.out.println(Arrays.toString(array));
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 1. 新建一个二维数组int[10][array.length], 第一维表示0~9十个数字的桶。
     *      第二位表示每个桶里的数字，为了防止越界，故将第二维的大小设置为array.length，一个典型的用空间换时间的算法；
     * 2. 新建一个一维数组int[10]从来记录每个桶中已经放置了多少个数字
     * @param array
     */
    public static void radixSort(int[] array) {
        int[][] bucket = new int[10][array.length];
        int[] bucketNumCount = new int[10];

        /*
        寻找原始数组中的最大值，并确定其位数，根据此位数确定循环次数
         */
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 最大数的位数，即为循环的次数
        int maxLen = String.valueOf(max).trim().length();

        /*
        1. i为循环轮数；
        2. n是为了求位数的除数
         */
        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            // 循环遍历每个数，将其存入对应的桶
            for (int j = 0; j < array.length; j++) {
                // 每位的数字
                int bitNum = array[j] / n % 10;
                /*
                1. 经过计算，把array[i]存到对应的桶对应的位置
                2. bitNum代表该数某位上的值，因为bucket[bitNum][] 代表该桶；
                3. bucketNumCount[bitNum]中的数代表bitNum该数所对应的桶应该在第几个位置存放数据；
                 */
                bucket[bitNum][bucketNumCount[bitNum]] = array[j];
                bucketNumCount[bitNum]++;
            }

            /*
            遍历每一个桶，将每个桶中的数字按顺序取出放置源数组中
             */
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                // bucketNumCount[k] != 0 说明编号为 k 的桶中存有数据
                if (bucketNumCount[k] != 0) {
                    //遍历编号为 k 的桶，将其中的数据取出，放置在源数组中
                    for (int h = 0; h < bucketNumCount[k]; h++) {
                        array[index++] = bucket[k][h];
                    }
                    // 遍历完成后将bucketNumCount[k]出元素置为0，方便下轮计数
                    bucketNumCount[k] = 0;
                }
            }
        }
    }

}
