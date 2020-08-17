package balancebinarytree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // 左旋测试数组
       // int[] arr = {4, 3, 6, 5, 7, 8};

        // 右旋测试数组
        // int[] arr = {10, 12, 8, 9, 7, 6};

        // 双旋测试数组(LR型)
        // int[] arr = {10, 11, 7, 6, 8, 9};

        // 双旋测试数组(RL型)
        int[] arr = {2, 1, 6, 5, 7, 3};


        for (int i = 0; i < arr.length; i++) {
            AVLTreeNode avlNode = new AVLTreeNode(arr[i]);
            avlTree.insert(avlNode);
        }

        // 遍历
        avlTree.list();
        System.out.println("当前树根节点是：" + avlTree.root);
        // 根节点高度
        int rootHeight = avlTree.height(avlTree.root);
        System.out.println("这棵树根节点的高度：" + rootHeight);
        // 根节点左子树高度
        int rootLeftHeight = avlTree.height(avlTree.root.leftChild);
        System.out.println("这棵树根节点左子树的高度：" + rootLeftHeight);
        // 根节点右子树高度
        int rootRightHeight = avlTree.height(avlTree.root.rightChild);
        System.out.println("这棵树根节点右子树的高度：" + rootRightHeight);
    }
}
