package binarytree;

/**
 * 线索二叉树
 * @author xuyifan
 */
public class ThreadedBinaryTree {

    /**
     * 根节点
     */
    private TreeNode root;

    /**
     * 线索化节点时需要，表示当前正在线索化节点的前驱节点
     * 为什么需要此辅助索引：因为遍历到当前节点后，无法在追溯到其前驱节点
     */
    private TreeNode preNode;

    public ThreadedBinaryTree(TreeNode root) {
        this.root = root;
    }

    public void threadedTreePreOrder() {
        threadedTreeByPreOrder(root);
    }

    /**
     * 对外提供方法
     * 以中序遍历的方式线索化二叉树
     */
    public void threadedTreeByInOrder() {
        threadedTreeByInOrder(root);
    }

    /**
     * 以前序遍历的方式线索化二叉树
     * @param node
     */
    private void threadedTreeByPreOrder(TreeNode node) {
        if (node != null) {
            /*
            线索化当前节点
             */
            if (node.leftChild == null) {
                node.leftChild = preNode;
                node.leftTag = 1;
            }
            if (preNode != null && preNode.rightChild == null) {
                preNode.rightChild = node;
                preNode.rightTag = 1;
            }
            preNode = node;

            // 向左线索化
            if (node.leftTag == 0) {
                threadedTreeByPreOrder(node.leftChild);
            }
            // 向右线索化
            if (node.rightTag == 0) {
                threadedTreeByPreOrder(node.rightChild);
            }
        }
    }

    /**
     * 以中序遍历的方式线索化二叉树
     * @param node
     */
    private void threadedTreeByInOrder(TreeNode node) {
        if (node != null) {
            // 向左线索化二叉树
            threadedTreeByInOrder(node.leftChild);

            /*
            线索化当前节点
             */
            // 如果该节点没有左子节点，将其leftChild指向该节点的前驱节点并更改标志位
            if (node.leftChild == null) {
                node.leftChild = preNode;
                node.leftTag = 1;
            }

            /*
            如果不继续向下遍历是无法知道该节点后继节点，而当前节点为pre的后继节点，
            因此将该节点前驱节点pre的后继节点的判断放置在当前节点的前驱节点处理完后
            这是一个技巧点，细品一下！！
             */
            if (preNode != null && preNode.rightChild == null) {
                preNode.rightChild = node;
                preNode.rightTag = 1;
            }
            // 继续向后线索化，当前节点的后继节点的前驱节点为当前节点，非常重要的一步！细品一下！！！
            preNode = node;

            // 向右线索化二叉树
            threadedTreeByInOrder(node.rightChild);
        }
    }

    /**
     * 遍历中序线索化的二叉树
     *  如果看不懂，debug一下，在结合正常二叉树的中序遍历，可以找到一些思路
     */
    public void listInOrder() {
        // 辅助指针，从根节点开始遍历
        TreeNode current = root;

        /*
        中序遍历
            先找左子节点
            输出节点
            找右子节点
         */
        while (current != null) {
            // 如果当前节点的左指针为左子节点，继续向左寻找
            while (current.leftTag == 0) {
                current = current.leftChild;
            }

            // 运行到这里就找到了左节点为空的节点，在线索二叉树中是将其进行了线索化
            System.out.println(current);

            // 寻找该节点的后继节点，==1时找到后继节点，直接输出
            while (current.rightTag == 1) {
                current = current.rightChild;
                System.out.println(current);
            }

            // 如果当前节点的右指针为右子节点，继续向右寻找
            current = current.rightChild;
        }
    }

    /**
     * 遍历前序序线索化的二叉树
     */
    public void listPreOrder() {
        // 辅助指针，从根节点开始遍历
        TreeNode current = root;

        /*
        中序遍历
            输出节点
            找左子节点
            找右子节点
         */
        while (current != null) {
            System.out.println(current);

            // 如果当前节点的左指针为左子节点，继续向左寻找
            if (current.leftTag == 0) {
                current = current.leftChild;
                continue;
            }

            // 寻找该节点的后继节点，==1时找到后继节点，直接输出
            while (current.rightTag == 1) {
                current = current.rightChild;
                System.out.println(current);
            }

            // 如果当前节点的右指针为右子节点，继续向右寻找
            current = current.rightChild;
        }
    }
}
