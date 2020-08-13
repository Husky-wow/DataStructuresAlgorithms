package balancebinarytree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 4, 13, 14};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            AVLTreeNode node = new AVLTreeNode(array[i]);
            avlTree.insert(node);
        }

        int height = avlTree.height(avlTree.root);
        System.out.println(height);

        avlTree.list();
    }
}
