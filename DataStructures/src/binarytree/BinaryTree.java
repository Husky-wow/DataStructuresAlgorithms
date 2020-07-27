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
     * 对外提供的方法
     */
    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 前序遍历，递归，回溯
     *  1. 先输出当前节点
     *  2. 向左遍历
     *  3. 向右遍历
     * 结束条件：node == null
     * @param node
     */
    private void preOrder(TreeNode node) {
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
    private void inOrder(TreeNode node) {
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
    private void postOrder(TreeNode node) {
        if (node != null) {
            // 向左遍历
            postOrder(node.leftChild);
            // 向右遍历
            postOrder(node.rightChild);
            // 输出当前节点
            System.out.println(node.toString());
        }
    }

    /**
     * 从node节点开始，前序查找编号为no的节点
     * @param node
     * @param no
     */
    public TreeNode getByPreOrder(TreeNode node, int no) {

        if (node != null) {
            // 与当前节点做比较
            if (node.no == no) {
                return node;
            }
            // 向左遍历
            TreeNode leftResult = getByPreOrder(node.leftChild, no);
            if (leftResult != null) {
                return leftResult;
            }
            // 向右遍历
            return  getByPreOrder(node.rightChild, no);
        } else {
            return null;
        }
    }

    /**
     * 从node节点开始，中序查找编号为no的节点
     * @param node
     * @param no
     */
    public TreeNode getByInOrder(TreeNode node, int no) {

        if (node != null) {
            // 向左遍历
            TreeNode leftResult = getByInOrder(node.leftChild, no);
            if (leftResult != null) {
                return leftResult;
            }
            // 与当前节点做比较
            if (node.no == no) {
                return node;
            }
            // 向右遍历
            return  getByInOrder(node.rightChild, no);
        } else {
            return null;
        }
    }

    /**
     * 从node节点开始，后序查找编号为no的节点
     * @param node
     * @param no
     */
    public TreeNode getByPostOrder(TreeNode node, int no) {

        if (node != null) {
            // 向左遍历
            TreeNode leftResult = getByPostOrder(node.leftChild, no);
            if (leftResult != null) {
                return leftResult;
            }

            //向右遍历
            TreeNode rightResult = getByPostOrder(node.rightChild, no);
            if (rightResult != null) {
                return rightResult;
            }

            // 与当前节点做比较
            if (node.no == no) {
                return node;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
