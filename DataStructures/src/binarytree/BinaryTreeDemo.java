package binarytree;

/**
 * @author admin
 * @ClassName BinaryTreeDemo.java
 * @Description TODO
 * @createTime 2020年07月22日 00:35:00
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        /*
        先手动建立一个树
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.leftChild = node2;
        node1.rightChild = node3;
        node3.leftChild = node5;
        node3.rightChild = node4;

        // 新建树
        BinaryTree binaryTree = new BinaryTree(node1);
        // 从根节点开始遍历
        System.out.println("前序遍历");
        binaryTree.preOrder(node1);

        System.out.println("中序遍历");
        binaryTree.inOrder(node1);

        System.out.println("后序遍历");
        binaryTree.postOrder(node1);


    }
}
