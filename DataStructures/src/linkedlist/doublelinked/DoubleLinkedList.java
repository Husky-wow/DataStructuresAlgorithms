package linkedlist.doublelinked;

/**
 * @author admin
 * @ClassName DoubleLinkedList.java
 * @Description 双向链表，存在头节点,节点为linkedlist.doublelinked.HeroNode
 * @createTime 2020年06月23日 21:47:00
 */
public class DoubleLinkedList {

    /**
     * 头节点
     */
    private final HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加方法
     * 从头节点开始遍历节点，找到next为空的节点，然后将next指向node
     * 即将新节点添加到链表的最后
     * @param node 需要添加的节点
     */
    public void add(HeroNode node) {
        // 当前正在遍历的节点
        HeroNode current = headNode;
        /*
        找到next为空的节点
         */
        while (current.next != null) {
            current = current.next;
        }
        // 将current.next指向node
        current.next = node;
        // node.pre指向current
        node.pre = current;
    }

    /**
     * 按顺序添加
     * 找到节点添加的位置（当前节点的后边）
     * 即current.next.no > node.no时，将node添加到当前节点的后边
     *
     * @param node 需要添加的节点
     */
    public void addByOrder(HeroNode node) {
        /*
        如果node.no = 0,，即node.no = headNode.no，无法添加
        */
        if (node.no == 0) {
            System.out.println("节点 no 不能等于0，无法添加");
            return;
        }
        // 从头节点开始遍历
        HeroNode current = headNode;
        /*
        循环遍历，当前节点的下一个节点不为空
         */
        while (current.next != null) {
            // current.next.no > node.no找到节点
            if (current.next.no > node.no) {
                break;
            } else if (current.next.no == node.no) {
                System.out.println("该节点已经存在，无法添加");
                return;
            }
            current = current.next;
        }
        /*
        加入节点
        current.next != null node添加到中间节点
         */
        node.next = current.next;
        node.pre = current;
        if (current.next != null) {
            current.next.pre = node;
        }
        current.next = node;
    }

    /**
     * 找到链表中 no为 node.no的节点，并将该节点更新
     * @param node
     */
    public void update(HeroNode node) {
        // 从第一个节点开始遍历
        HeroNode current = headNode.next;

        while (current != null) {
            if (current.no == node.no) {
                current.name = node.name;
                current.nickName = node.nickName;
                return;
            }
            current = current.next;
        }
        // current == null时执行
        System.out.println("在当前链表中没有找到该节点，无法更新");
    }

    /**
     * 根据删除no节点
     * current为当前带删除的节点
     * @param no
     */
    public void delete(int no) {
        // 从第一个节点开始遍历
        HeroNode current = headNode.next;

        while (current != null) {
            if (current.no == no) {
                current.pre.next = current.next;
                current.next.pre = current.pre;
                current.next = null;
                current.pre = null;
                return;
            }
            current = current.next;
        }

        System.out.println("没有找到可删除的节点");
    }

    /**
     * 遍历链表，从节点指向的节点开始输出
     * 同单向链表
     */
    public void list() {
        HeroNode current = headNode.next;
        /*
        头节点next为空，说明链表中没有存储节点
         */
        if (current == null) {
            System.out.println("该链表中没有存储元素");
        }

        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    /**
     * 求链表中节点个数，不算头节点
     * @return
     */
    public int size() {
        int count = 0;
        // 从头节点开始遍历
        HeroNode current = headNode;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        return count;
    }


}
