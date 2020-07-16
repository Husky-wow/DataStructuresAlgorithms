package search;

/**
 * @author admin
 * @ClassName InterpolationSearch.java
 * @Description TODO
 * @createTime 2020年07月16日 23:53:00
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 50, 70, 100};
        int resultIndex = interpolationSearch(arr, 50, 0, arr.length - 1);
        System.out.println(resultIndex);
    }

    /**
     * 插值查找
     *  该算法适合数据量较大，关键字分部比较均匀的数组；
     *  关键字分布不均匀的情况下，该方法不一定比二分查找好
     *  有序数组！！！！
     * @param array
     * @param targetValue
     * @param left
     * @param right
     * @return
     */
    public static int interpolationSearch(int[] array, int targetValue, int left, int right) {

        if (left > right || targetValue < array[0] || targetValue > array[array.length - 1]) {
            return -1;
        }

        if (array[0] == array[array.length - 1]) {
            System.out.println("数组所有元素一致");
            if (array[0] == targetValue) {
                return 0;
            } else {
                return -1;
            }
        }

        // 插值搜索的 mid 计算为该算法的核心
        int mid = left + (right - left) * (targetValue - array[left]) / (array[right] - array[left]);

        if (targetValue < array[mid]) {
            // 向左查找
            return interpolationSearch(array, targetValue, left, mid - 1);
        } else if (targetValue > array[mid]) {
            // 向右查找
            return interpolationSearch(array, targetValue, mid + 1, right);
        } else {
            return mid;
        }
    }
}
