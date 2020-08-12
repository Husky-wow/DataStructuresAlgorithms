package balancebinarytree;

/**
 * 平衡二叉树
 */
public class AVLTree {

    public AVLNode root;

    public int height(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    /**
     * 添加方法, < 添加到左节点， >= 添加到右子节点
     * 感觉应该有更好的方法。。回家看看
     * @param node 插入节点
     */
    public void insert(AVLNode node) {
        if (node == null) {
            return;
        }

        if (root == null) {
            root = node;
            return;
        }
        // 从根节点扫描
        AVLNode current = root;
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

    public void list() {
        inOrder(root);
    }

    /**
     * 中序遍历
     */
    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node);
            inOrder(node.rightChild);
        }
    }

}
