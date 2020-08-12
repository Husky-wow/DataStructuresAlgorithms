package balancebinarytree;

/**
 * 平衡二叉树节点
 */
public class AVLNode {
    public int value;

    public AVLNode leftChild;

    public AVLNode rightChild;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
