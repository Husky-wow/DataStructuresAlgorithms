package binarytree;

/**
 * @author xuyifan
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        preOrder();

        //inorder();
    }

    private static void preOrder() {
    /*
    手动造一个二叉树
     */
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        root.leftChild = node3;
        root.rightChild = node6;
        node3.leftChild = node8;
        node3.rightChild = node10;
        node6.leftChild =node14;

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedTreePreOrder();

        // 遍历前序线索二叉树
        threadedBinaryTree.listPreOrder();

        // 测试 8号节点
        System.out.println("8号节点的前驱节点：" + node8.leftChild);
        System.out.println("8号节点的后继节点：" + node8.rightChild);

        // 测试 10号节点
        System.out.println("10号节点的前驱节点：" + node10.leftChild);
        System.out.println("10号节点的后继节点：" + node10.rightChild);

        // 测试 14号节点
        System.out.println("14号节点的前驱节点：" + node14.leftChild);
        System.out.println("14号节点的前驱节点：" + node14.rightChild);
    }

    private static void inOrder() {
    /*
    手动造一个二叉树
     */
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        root.leftChild = node3;
        root.rightChild = node6;
        node3.leftChild = node8;
        node3.rightChild = node10;
        node6.leftChild =node14;

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedTreeByInOrder();

        // 遍历中序线索二叉树
        threadedBinaryTree.listInOrder();

        // 测试 8号节点
        TreeNode testNode1 = node8.leftChild;
        System.out.println("8号节点的前驱节点：" + testNode1);

        // 测试 10号节点
        TreeNode testNode2 = node10.leftChild;
        System.out.println("10号节点的前驱节点：" + testNode2);

        // 测试 14号节点
        TreeNode testNode3 = node14.leftChild;
        System.out.println("14号节点的前驱节点：" + testNode3);
    }
}
