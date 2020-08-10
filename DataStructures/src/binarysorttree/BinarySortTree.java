package binarysorttree;

/**
 * 二叉搜索树BST
 */
public class BinarySortTree {

    public Node root;

    /**
     * 查找value值为 key 的节点
     * @param key 查找值
     * @return 返回节点对象
     */
    public Node find(int key) {
        // 从root节点开始遍历树
        Node current = root;
        while (current != null && current.value != key) {
            if (key < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return current;
    }

    /**
     * 寻找以Node节点为根节点的树中 value 值最小的节点
     *  找到没有左子树的节点，该节点就为树的中最小节点
     * @param node 根节点
     * @return 返回 value 值最小的节点
     */
    public Node min(Node node) {
        if (node == null) {
            // 根节点为空
            return null;
        }

        // 遍历辅助节点
        Node current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current;
    }

    /**
     * 寻找以Node节点为根节点的树中 value 值最大的节点
     *  找到没有右子树的节点，该节点就为树的中最大节点
     * @param node 根节点
     * @return 返回 value 值最大的节点
     */
    public Node max(Node node) {
        if (node == null) {
            // 根节点为空
            return null;
        }

        // 遍历辅助节点
        Node current = node;
        while (current.rightChild != null) {
            current = current.rightChild;
        }

        return current;
    }

    /**
     * 添加方法, < 添加到左节点， >= 添加到右子节点
     * 感觉应该有更好的方法。。回家看看
     * @param node 插入节点
     */
    public void insert(Node node) {
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
     * 删除 value 值为key的节点，下述当前节点就为要删除的节点
     *  1. 如果该节点没有子节点，即该节点为叶子节点，直接将父节点的子节点置为null
     *  2. 如果该节点有一个子节点，将节点的子节点置为父节点的子节点
     *  3. 如果该节点有两个子节点
     *      3.1 找出该节点中序遍历下的前序节点（即左子树中value值最大的节点），将父节点的子节点置为该前序节点，该节点子节点还是子节点
     *      或者
     *      3.1 找出该节点中序遍历下的后继节点（即右子树中value值最小的节点），将父节点的子节点置为该后继节点，该节点子节点还是子节点
     *     本例中采用后继节点
     *  4. 上述删除有两个子节点的节点的方法是正常的删除方法，但是这里提供一个取巧的方法
     *      4.1 找后中序遍历的后继节点；
     *      4.2 当前节点的value值变为后继节点的value值
     *      4.3 删除后继节点（直接递归调用delete方法，因为后继节点必然只有一个右子节点）
     *      是不是很鸡贼
     * @param key 需要删除节点的value值
     * @return 删除结果
     */
    public boolean delete(int key) {
        /*
        首先寻找要删除的节点，因为删除节点还需要其父子节点，因此这里不调用find方法
         */
        Node current = root;
        Node parent = null;

        while (current != null && current.value != key) {
            parent = current;
            if (key < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        // current 为要删除的节点
        if (current != null) {
            if (current.leftChild == null && current.rightChild == null) {
                // 要删除的节点为叶子节点
                if (current == root) {
                    // 要删除的节点为叶子节点，并且当前节点为根节点
                    root = null;
                } else {
                    if (parent.leftChild == current) {
                        // 要删除的节点为叶子节点，并且为父节点的左子节点
                        parent.leftChild = null;
                    } else if (parent.rightChild == current) {
                        // 要删除的节点为叶子节点，并且为父节点的右子节点
                        parent.rightChild = null;
                    }
                }
                return true;
            } else if (current.leftChild == null) {
                // 要删除的节点有一个右子节点
                if (current == root) {
                    // 要删除的节点为根节点
                    root = root.rightChild;
                } else {
                    if (parent.leftChild == current) {
                        // 要删除的节点为父节点的左子节点
                        parent.leftChild = current.rightChild;
                    } else if (parent.rightChild == current) {
                        // 要删除的节点为父节点的右子节点
                        parent.rightChild = current.rightChild;
                    }
                }
                return true;
            } else if (current.rightChild == null) {
                // 要删除的节点有一个左子节点
                if (current == root) {
                    root = root.leftChild;
                } else {
                    if (parent.leftChild == current) {
                        parent.leftChild = current.leftChild;
                    } else if (parent.rightChild == current) {
                        parent.rightChild = current.leftChild;
                    }
                }
                return true;
            } else {
                // 要删除的节点有两个子节点

                /*
                 1 找后中序遍历的后继节点，即获取以current.right为根节点的树的最小节点；
                 2 当前节点的value值变为后继节点的value值
                 3 删除后继节点（直接递归调用delete方法，因为后继节点必然只有一个右子节点）
                 */
                Node successor = min(current.rightChild);
                delete(successor.value);
                current.value = successor.value;
                return true;
            }
        } else {
            // 没有找到要删除的节点
            return false;
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
