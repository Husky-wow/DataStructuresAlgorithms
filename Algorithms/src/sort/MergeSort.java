package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 * @ClassName MergeSort.java
 * @Description TODO
 * @createTime 2020年07月09日 22:36:00
 */
public class MergeSort {

    static int dataNum = 8000000;

    public static void main(String[] args) {
        //int[] oriArr = {5, 1, 9, 3, 7, 4, 8, 6, 2};

        int[] oriArr = new int[dataNum];
        for (int i = 0; i < dataNum; i++) {
            oriArr[i] = (int) (Math.random() * 8000000);
        }
        int[] tempArr = new int[oriArr.length];

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date1));

        mergeSort(oriArr, tempArr, 0, oriArr.length -1);

        Date date2 = new Date();
        System.out.println("排序前的时间是：" + simpleDateFormat.format(date2));

        //System.out.println(Arrays.toString(oriArr));
    }


    /**
     * 1. 分隔originalArr，直至分隔至子数组只剩一个元素
     * 2. 将左右两个子数组有序合并至一个数组
     *      注：从始至终只使用一个临时数组 tempArr，节省因新建数组造成的开销
     * @param originalArr 原始数组
     * @param tempArr 有序合并临时数组
     * @param startIndex 归并排序数组的起始位置
     * @param endIndex 归并排序数组的结束位置
     */
    public static void mergeSort(int[] originalArr, int[] tempArr, int startIndex, int endIndex) {
        // 递归结束条件 startIndex
        if (startIndex < endIndex) {
            // 分隔位置 (endIndex - startIndex) / 2 + startIndex
            int midIndex = (endIndex + startIndex) / 2;

            // 分隔左半边
            mergeSort(originalArr, tempArr, startIndex, midIndex);

            // 分隔右半边
            mergeSort(originalArr, tempArr, midIndex + 1, endIndex);

            // 合作左右半边
            mergeSubArray(originalArr, tempArr, startIndex, midIndex, endIndex);

        }



    }

    /**
     * 合并分隔后的子数组
     *      思路：按顺序合并两个有序数组
     * @param oriArr 原始数组，即子数组的父数组
     * @param tempArr 将两个子数组有序合并到tempArr中
     * @param startIndex 子数组在原始数组中开始索引位置
     * @param midIndex 开收和结束中间分隔原始数组的位置
     * @param endIndex 子数组在原始数组中结束索引位置
     */
    private static void mergeSubArray(int[] oriArr, int[] tempArr, int startIndex, int midIndex, int endIndex) {

        int left = startIndex;
        int right = midIndex + 1;
        // tempArr存放元素位置索引
        int tempIndex = startIndex;

        /*
        按顺序合并两个有序数组
         */
        while (left <= midIndex && right <= endIndex){
            if (oriArr[left] <= oriArr[right]){
                tempArr[tempIndex] = oriArr[left];
                left ++;
            } else {
                tempArr[tempIndex] = oriArr[right];
                right ++;
            }
            tempIndex++;
        }

        /*
        将子数组中剩余的元素存入tempArr中
         */
        while (tempIndex <= endIndex) {
            if (left <= midIndex){
                tempArr[tempIndex] = oriArr[left];
                left ++;
            } else if (right <= endIndex){
                tempArr[tempIndex] = oriArr[right];
                right ++;
            }
            tempIndex++;
        }

        /*
        将tempArr中相应位置的元素拷贝至oriArr中
         */
        for (int i = startIndex; i <= endIndex; i++) {
            oriArr[i] = tempArr[i];
        }
    }


}
