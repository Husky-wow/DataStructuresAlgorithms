package binarysorttree;

/**
 * 二叉搜索树（BST）节点
 */
public class Node {
    public int value;

    public Node leftChild;

    public Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
