package sort;

/**
 * 二分查找
 *  二分查找的前提是，数组是已经有序的
 *    本例中采用升序排列
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 50, 70, 100};
        int resultIndex = binarySearch(arr, 5, 0, arr.length - 1);
        System.out.println(resultIndex);
    }

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

}
