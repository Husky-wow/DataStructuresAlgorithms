package balancebinarytree;

/**
 * 平衡二叉搜索树
 *  insert方法使用了递归方法
 *      为什么？因为是平衡排序二叉树，所以每插入一个节点就要判断树是否平衡，而且还要找出旋转的中心节点；
 *      而且有一个问题目前没有找到非递归的解决方法：
 *          那就是插入一个新节点后，插入新节点的节点父节点（新节点的爷爷节点）所在子树并不一定是非平衡的；
 *      目前，我能找到并理解的方法就是递归方法，所以无奈采用递归方法。
 *
 */
public class AVLTree {

    public AVLTreeNode root;

    /**
     * 获取节点的高度
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
     * 以当前节点为根节点的子树不平衡，左子树高度 < 右子树高度
     * @param curNode 当前节点
     */
    private void leftRotation(AVLTreeNode curNode) {
        // 1. 新建一个节点作为新的左子节点，其value值为当前节点值
        AVLTreeNode newNode = new AVLTreeNode(curNode.value);
        // 2. 新节点的左子节点 = 当前节点的左子节点
        newNode.leftChild = curNode.leftChild;
        // 3. 新节点的右子节点 = 当前节点右子节点的左子节点
        newNode.rightChild = curNode.rightChild.leftChild;
        // 4. 当前节点的value = 当前节点的右子节点的value值
        curNode.value = curNode.rightChild.value;
        // 5. 当前节点的左子节点 = 新节点
        curNode.leftChild = newNode;
        // 6. 当前节点的右子节点 = 当前节点的右子节点的右子节点
        curNode.rightChild = curNode.rightChild.rightChild;
    }

    /**
     * 以当前节点为根节点的子树不平衡， 左子树高度 > 右子树高度
     * @param curNode 当前节点
     */
    private void rightRotation(AVLTreeNode curNode) {
        // 1. 新建一个节点，其value值等于当前节点
        AVLTreeNode newNode = new AVLTreeNode(curNode.value);
        // 2. 新节点的右子树 = 当前节点的右子树
        newNode.rightChild = curNode.rightChild;
        // 3. 新节点的左子树等于当前节点的左子树的右子树
        newNode.leftChild =curNode.leftChild.rightChild;
        // 4. 当前节点的value = 当前节点的左子节点的value值
        curNode.value = curNode.leftChild.value;
        // 5. 当前节点的右子节点 = 新节点
        curNode.rightChild = newNode;
        // 6. 当前节点的左子节点 = 当前节点的左子节点的左子节点
        curNode.leftChild = curNode.leftChild.leftChild;
    }

    /**
     * 对外暴露的insert方法
     * @param node 需要插入的节点
     */
    public void insert(AVLTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    /**
     * 添加新节点，向以curNode为根节点的子树添加newNode
     * @param curNode 以curNode为根节点的子树
     * @param newNode 需要添加的节点
     * TODO 目前没有想到非递归的方法？应该是能改进的
     */
    private void insert(AVLTreeNode curNode, AVLTreeNode newNode) {
        if (newNode == null) {
            return;
        }

        if (newNode.value < curNode.value) {
            if (curNode.leftChild != null) {
                insert(curNode.leftChild, newNode);
            } else {
                curNode.leftChild = newNode;
            }
        } else {
            if (curNode.rightChild != null) {
                insert(curNode.rightChild, newNode);
            } else {
                curNode.rightChild = newNode;
            }
        }

         /*
         每插入一个节点就判断以curNode为根节点的子树是否平衡
          */
        if (height(curNode.rightChild) - height(curNode.leftChild) > 1) {
            if (height(curNode.rightChild.leftChild) > height(curNode.rightChild.rightChild)) {
                // 当前节点的右子树的左子树高度 > 当前节点的右子树的右子树（RL型）
                // 先对当前节点的右子树右旋
                rightRotation(curNode.rightChild);
                // 然后对当前节点左旋
            }
            // 以curNode为根节点的树：其右子树高度 - 左子树高度 > 1 左旋(RR型)
            leftRotation(curNode);

            // 树以平衡，无需继续向下执行
            return;
        }

        if (height(curNode.leftChild) - height(curNode.rightChild) > 1) {
            if (height(curNode.leftChild.rightChild) > height(curNode.leftChild.leftChild)) {
                // 当前节点的左子树的右子树高度 > 当前节点的左子树的左子树高度（LR型）
                // 先对当前节点的左子节点进行左旋
                leftRotation(curNode.leftChild);
                // 然后对当前节点进行右旋
            }
            // 以curNode为根节点的树：其左子树高度 - 右子树高度 > 1 右旋（LL型）
            rightRotation(curNode);
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
