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
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.leftChild = node2;
        root.rightChild = node3;
        node3.leftChild = node5;
        node3.rightChild = node4;

        // 新建树
        BinaryTree binaryTree = new BinaryTree(root);


        // 从根节点开始遍历
        System.out.println("前序遍历");
        binaryTree.preOrder(root);

        System.out.println("中序遍历");
        binaryTree.inOrder(root);

        System.out.println("后序遍历");
        binaryTree.postOrder(root);


        System.out.println("前序遍历查找~~~");
        TreeNode resultPre = binaryTree.getByPreOrder(root, 1);
        if (resultPre != null) {
            System.out.println(resultPre.toString());
        } else {
            System.out.println("没有找到");
        }

        System.out.println("中序遍历查找~~~");
        TreeNode resultIn = binaryTree.getByInOrder(root, 6);
        if (resultIn != null) {
            System.out.println(resultIn.toString());
        } else {
            System.out.println("没有找到");
        }

        System.out.println("后续遍历查找~~~");
        TreeNode resultPost = binaryTree.getByPostOrder(root, 5);
        if (resultPost != null) {
            System.out.println(resultPost.toString());
        } else {
            System.out.println("没有找到");
        }

    }
}
