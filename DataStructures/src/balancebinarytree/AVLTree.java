package balancebinarytree;

/**
 * 平衡二叉树
 */
public class AVLTree {

    public AVLTreeNode root;

    /**
     * 求当前节点的高度(左子树高度和右子树高度中的最大值)
     * @param node
     * @return
     */
    public int height(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    /**
     * 求当前节点的左子树高度
     * @param node
     * @return
     */
    public int leftHeight(AVLTreeNode node) {
        if (node != null) {
            if (node.leftChild == null) {
                return 0;
            } else {
                return height(node.leftChild);
            }
        } else {
            return 0;
        }
    }

    /**
     * 求当前节点的右子树高度
     * @param node
     * @return
     */
    public int rightHeight(AVLTreeNode node) {
        if (node != null) {
            if (node.rightChild == null) {
                return 0;
            } else {
                return height(node.rightChild);
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加方法, < 添加到左节点， >= 添加到右子节点
     * 感觉应该有更好的方法。。回家看看
     * @param node 插入节点
     */
    public void insert(AVLTreeNode node) {
        if (node == null) {
            return;
        }

        if (root == null) {
            root = node;
            return;
        }
        // 从根节点扫描
        AVLTreeNode current = root;
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
    private void inOrder(AVLTreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node);
            inOrder(node.rightChild);
        }
    }

}
