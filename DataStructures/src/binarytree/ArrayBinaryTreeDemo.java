package binarytree;

/**
 * @author xuyifan
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(array);
        // 前序遍历
        tree.preOrder();

        // 中序遍历
        System.out.println();
        tree.inOrder();

        // 后序遍历
        System.out.println();
        tree.postOrder();
    }
}
