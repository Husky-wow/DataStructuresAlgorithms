package binarytree;

/**
 * 数组存储二叉树并进行遍历
 *
 * 某个节点的左子节点其所在数组的索引为 2 * n + 1
 * 某个节点的右子节点其所在数组的索引为 2 * n + 2
 * 某个节点的父节点所在数组的索引为 (n - 1) / 2
 * @author xuyifan
 */
public class ArrayBinaryTree {

    private int[] binaryTreeArray;

    public ArrayBinaryTree(int[] binaryTreeArray) {
        this.binaryTreeArray = binaryTreeArray;
    }

    /**
     * 对外提供的方法
     */
    public void preOrder() {
        preOrder(0);
    }

    public void inOrder() {
        inOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }

    /**
     * 从数组的第index个元素进行前序遍历
     * @param index
     */
    private void preOrder(int index) {
        if (binaryTreeArray != null
                && index < binaryTreeArray.length
                && index >= 0) {

            // 先打印自己
            System.out.print(binaryTreeArray[index] + "\t");
            // 向左遍历
            preOrder(2 * index + 1);
            // 向右遍历
            preOrder(2 * index + 2);
        }

    }

    /**
     * 中序遍历
     * @param index
     */
    private void inOrder(int index) {
        if (binaryTreeArray != null
                && index < binaryTreeArray.length
                && index >= 0) {

            // 向左遍历
            inOrder(2 * index + 1);
            // 打印自己
            System.out.print(binaryTreeArray[index] + "\t");
            // 向右遍历
            inOrder(2 * index + 2);
        }
    }

    /**
     * 后序遍历
     * @param index
     */
    private void postOrder(int index) {
        if (binaryTreeArray != null
                && index < binaryTreeArray.length
                && index >= 0) {

            // 向左遍历
            postOrder(2 * index + 1);
            // 向右遍历
            postOrder(2 * index + 2);
            // 打印自己
            System.out.print(binaryTreeArray[index] + "\t");
        }
    }

}
