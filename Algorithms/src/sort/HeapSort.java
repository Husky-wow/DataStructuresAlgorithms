package sort;

import java.util.Arrays;

/**
 * @author admin
 * @ClassName HeapSort.java
 * @Description TODO
 * @createTime 2020年07月30日 00:10:00
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     *  核心思想此处不做具体阐述
     *  明白核心思想后，可以总结，堆排序做解决两个问题：
     *      1. 如何由一个无序序列构成堆排序
     *      2， 如何在输出堆顶元素后，调整剩余元素成为一个新的堆
     * @param array
     */
    public static void heapSort(int[] array) {

        /*
        将无序序列先变成一个大顶堆
        所谓的将待排序的序列构建成为一个大顶堆，其实就是从下往上，从右到左，将每个非叶子节点当做根节点，将其和其子树调整成大顶堆
        为什么是从下往上，从右往左？
     *     大顶堆的组成就是父节点的数比两个子节点大，那肯定就是要找个每个非叶子节点，然后将其值变为其作为根节点的子树中最大的值，细品一下！！！
            1. 为什么i从 (array.length - 1) - 1开始？
               数组中最后一个索引存放的肯定是一个叶子节点，该节点的父节点肯定是最后一个非叶子节点，所以此节点开始！！
         */
        int lastIndex = array.length - 1;
        for (int i = (lastIndex - 1) / 2 ; i >= 0; i-- ) {
            heapAdjust(array, i, lastIndex);
        }

        /*
        1. 得到一个大顶堆后，此时根节点值最大，将根节点放置在数组最后
        2. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
         */
        for (int i = lastIndex; i > 0; i--) {
            /*
            交换第一个元素和最后一个元素
             */
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // 这里为什么 是从0开始，你想想，交换后是不是索引 1 到倒数第二个之间的数组成的二叉树满足一个大顶堆的概念，
            // 是不是只要把索引为0的元素换下去就可以了，而不用从最后一个非叶子节点开始去调整大顶堆
            // 这个思路是不是有点像heapAdjust中交换后，继续向下确认一下，好好品一下，有点难理解！！！！
            heapAdjust(array, 0, i - 1);
        }

    }

    /**
     * 将一个无序数组表示的二叉树调整成大顶堆
     * @param array 需要调整的数组
     * @param i 非叶子节点索引
     * @param endIndex 从索引为i的非叶子节点开始，从endIndex表示的节点结束，该段数组元素所对应的二叉树为最终调整的二叉树
     *                 为什么要这样，我们要知道，每次调整后，是要将根节点的数和数组最后一个数做交换，然后将剩下的数在变成一个大顶堆
     *                 这以为这，每轮调整的数组的长度都在变化
     */
    private static void heapAdjust(int[] array, int i, int endIndex) {

        // 将当前非叶子节点的值记录下来
        int temp = array[i];

        /*
        开始调整
            从当前节点i的左子节点(k = 2 * i + 1)开始比较
            k<=结束索引前都可以比较
            下次就挪到k的左子节点开始比较（为什么要从k节点继续向下呢，因为交换后k的子节点作为根节点的子树可能不满足大顶堆条件，需要向下在确认一下）
         */
        for (int k = 2 * i + 1; k <= endIndex; k= k * 2 + 1) {

            if (k + 1 <= endIndex && array[k] < array[k + 1]) {
                // k + 1为 i 的右子节点，if表示 i 左子节点的值 < 右子节点的值, 此时挪到右子节点进行下一步
                k++;
            }

            // 经过上边的if，此时 k 所在位置为 i 的节点中较大的那一个元素，此时在比较k和i元素的大小
            if (array[k] > temp) {
                // 把较大的值赋给i节点
                array[i] = array[k];
                // 将 i 指向这次比较中的较大的那个数所在的位置，方便后续将temp的值赋给array[i]，这么做的目的是因为此处为了提高效率并没有交换i和k所在位置的值
                i = k;
            } else {
                // 如果 array[k] < temp,说明当前节点所在子树中并没有比当前节点大的值，
                // 并且是从下向上，从右至左寻找，那可以推断数组中该位置后边都没有比这个数大的值，因此可以直接退出循环
                break;
            }
        }

        // 退出循环后，i 所在位置为当前子树中最大值所在的位置，那个最大值已经被赋给了当前子树的根节点，因此要将根节点的值在赋值给i
        array[i] = temp;
    }
}
