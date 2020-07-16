package search;

import java.util.ArrayList;

/**
 * 二分查找
 *  二分查找的前提是，数组是已经有序的
 *    本例中采用升序排列
 */
public class BinarySearch {
    public static void main(String[] args) {
        /*int[] arr = {1, 3, 10, 50, 70, 100};
        int resultIndex = binarySearch(arr, 5, 0, arr.length - 1);
        System.out.println(resultIndex);*/

        int[] arr2 = {1, 3, 3, 3, 10, 50, 70, 100};;
        ArrayList<Integer> resultList = binarySearch2(arr2, 3, 0, arr2.length - 1);
        if (resultList != null) {
            for (Integer i: resultList) {
                System.out.println(i);
            }
        } else {
            System.out.println("没找到");
        }
    }

    /**
     * 二分查找
     * @param array 原始数组
     * @param targetValue 查找目标值
     * @param left
     * @param right
     * @return 没有找到返回 -1
     */
    private static int binarySearch(int[] array, int targetValue, int left, int right) {
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
    private static ArrayList<Integer> binarySearch2(int[] array, int targetValue, int left, int right) {
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
