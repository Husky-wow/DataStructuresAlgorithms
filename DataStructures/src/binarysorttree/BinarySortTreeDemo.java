package binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            binarySortTree.insertNode(node);
        }
        binarySortTree.list();
    }
}
