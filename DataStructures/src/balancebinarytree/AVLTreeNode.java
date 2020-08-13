package balancebinarytree;

/**
 * 平衡二叉树节点
 */
public class AVLTreeNode {
    public int value;

    public AVLTreeNode leftChild;

    public AVLTreeNode rightChild;

    public AVLTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
