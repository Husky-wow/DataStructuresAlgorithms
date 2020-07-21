package binarytree;

/**
 * @author admin
 * @ClassName BinaryTree.java
 * @Description 二叉树
 * @createTime 2020年07月22日 00:28:00
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历，递归，回溯
     *  1. 先输出当前节点
     *  2. 向左遍历
     *  3. 向右遍历
     * 结束条件：node == null
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            // 输出当前节点
            System.out.println(node.toString());
            // 向左遍历
            preOrder(node.leftChild);
            // 向右遍历
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历，递归，回溯
     *  1. 向左遍历
     *  2. 输出当前节点
     *  3. 向右遍历
     * 结束条件：node == null
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            // 向左遍历
            inOrder(node.leftChild);
            // 输出当前节点
            System.out.println(node.toString());
            // 向右遍历
            inOrder(node.rightChild);
        }
    }

    /**
     * 后遍历，递归，回溯
     *  1. 向左遍历
     *  2. 向右遍历
     *  3. 输出当前节点
     * 结束条件：node == null
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node != null) {
            // 向左遍历
            postOrder(node.leftChild);
            // 向右遍历
            postOrder(node.rightChild);
            // 输出当前节点
            System.out.println(node.toString());
        }
    }


}
