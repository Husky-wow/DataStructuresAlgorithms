package binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            binarySortTree.insert(node);
        }
        Node minNode = binarySortTree.min(binarySortTree.root);
        System.out.println("min: " + minNode);
        Node maxNode = binarySortTree.max(binarySortTree.root);
        System.out.println("max: " + maxNode);

        binarySortTree.list();

        /*System.out.println("删除7");
        binarySortTree.delete(7);
        System.out.println("删除7后的根节点");
        System.out.println(binarySortTree.root);
        binarySortTree.list();*/

        /*System.out.println("删除1");
        binarySortTree.delete(1);
        Node node3 = binarySortTree.find(3);
        System.out.println("删除1后3的左子节点：" + node3.leftChild);
        System.out.println("删除1后3的右子节点：" + node3.rightChild);
        System.out.println("删除1后遍历");
        binarySortTree.list();*/

        System.out.println("删除5");
        binarySortTree.delete(5);
        Node node3 = binarySortTree.find(3);
        System.out.println("删除5后3的左子节点：" + node3.leftChild);
        System.out.println("删除5后3的右子节点：" + node3.rightChild);
        System.out.println("删除5后遍历");
        binarySortTree.list();

        System.out.println("删除10");
        binarySortTree.delete(10);
        Node node7 = binarySortTree.find(7);
        System.out.println("删除10后7的右子节点：" + node7.rightChild);
    }
}
