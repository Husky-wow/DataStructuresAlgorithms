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

    /**
     * 左标志，为了线索二叉树添加
     *  为 0 时，leftChild指向左子节点
     *  为 1 时，leftChild指向前驱节点
     */
    public int leftTag = 0;

    /**
     * 右标志，同左标志
     */
    public int rightTag = 0;

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
