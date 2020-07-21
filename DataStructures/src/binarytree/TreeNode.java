package binarytree;

/**
 * @author admin
 * @ClassName TreeNode.java
 * @Description 树节点
 * @createTime 2020年07月22日 00:26:00
 */
public class TreeNode {
    public int no;
    /**
     * 左子节点
     */
    public TreeNode leftChild;

    /**
     * 右子节点
     */
    public TreeNode rightChild;

    public TreeNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }
}
