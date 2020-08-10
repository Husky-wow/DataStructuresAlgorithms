package binarysorttree;

/**
 * 二叉搜索树BST
 */
public class BinarySortTree {

    public Node root;

    /**
     * 添加方法, < 添加到左节点， >= 添加到右子节点
     * 感觉应该有更好的方法。。回家看看
     * @param node
     */
    public void insertNode(Node node) {
        if (node == null) {
            return;
        }

        if (root == null) {
            root = node;
            return;
        }
        // 从根节点扫描
        Node current = root;
        while (true) {
            if (node.value < current.value) {
                if (current.leftChild != null) {
                    current = current.leftChild;
                } else {
                    current.leftChild = node;
                    break;
                }
            } else {
                if (current.rightChild != null) {
                    current = current.rightChild;
                } else {
                    current.rightChild = node;
                    break;
                }
            }
        }
    }

    /**
     * 遍历BST
     *
     */
    public void list() {
        inOrder(root);
    }

    /**
     * 中序遍历
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node);
            inOrder(node.rightChild);
        }
    }

}
