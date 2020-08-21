package binarysearch;

import java.util.ArrayList;

/**
 * 二分查找
 *  二分查找的前提是，数组是已经有序的
 *    本例中采用升序排列
 */
public class BinarySearch {

    /**
     * 二分查找的非递归实现
     * @param array 原始数组
     * @param targetValue 查找目标值
     * @return 返回目标值在原始数组中的索引位置，如果没有找到则返回-1
     */
    public int binarySearch(int[] array, int targetValue) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                // 向右搜寻
                left = mid + 1;
            } else if (array[mid] > targetValue) {
                // 想左搜寻
                right = mid - 1;
            }
        }

        // 运行到这里表示没有找到哦啊
        return -1;
    }

    /**
     * 二分查找
     * @param array 原始数组
     * @param targetValue 查找目标值
     * @param left
     * @param right
     * @return 没有找到返回 -1
     */
    public int binarySearch(int[] array, int targetValue, int left, int right) {
        /*
        递归结束条件
         */
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (targetValue < array[mid]) {
            // 向左搜寻
            return binarySearch(array, targetValue, left, mid - 1);
        } else if (targetValue > array[mid]) {
            // 向右搜寻
            return binarySearch(array, targetValue, mid + 1, right);
        } else {
            // 相等

            return mid;
        }
    }

    /**
     * 找到数组中所有跟目标元素相同的下标
     * @param array
     * @param targetValue
     * @param left
     * @param right
     * @return
     */
    public ArrayList<Integer> binarySearch2(int[] array, int targetValue, int left, int right) {
        /*
        递归结束条件
         */
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        if (targetValue < array[mid]) {
            // 向左搜寻
            return binarySearch2(array, targetValue, left, mid - 1);
        } else if (targetValue > array[mid]) {
            // 向右搜寻
            return binarySearch2(array, targetValue, mid + 1, right);
        } else {
            /*
            向左找相同元素
             */
            ArrayList<Integer> resultList = new ArrayList<>();
            int temp = mid - 1;
            resultList.add(mid);
            while (temp >= 0 && array[temp] == targetValue) {
                resultList.add(temp);
                temp --;
            }
            /*
            向右寻找相同元素
             */
            temp = mid + 1;
            while (temp >= 0 && array[temp] == targetValue) {
                resultList.add(temp);
                temp ++;
            }

            return resultList;
        }
    }

}
