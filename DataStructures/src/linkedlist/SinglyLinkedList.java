package linkedlist;

/**
 * @author admin
 * @ClassName SinglyLinkedList.java
 * @Description 单向链表，每一个节点为一个SingleHeroNode，存在一个无数据的头节点
 * @createTime 2020年06月18日 23:18:00
 */
public class SinglyLinkedList {

    /**
     * 头节点
     */
    private final HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加方法
     * 从头节点开始遍历节点，找到next为空的节点，然后将next指向node
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
        // 将next指向node
        current.next = node;
    }

    /**
     * 按顺序添加
     * 找到节点添加的未知(temp和temp.next的中间)
     * 一个节点的no > node.no，则node添加到该节点之前
     *
     * @param node 需要添加的节点
     */
    public void addByOrder(HeroNode node) {
        // 从头节点开始遍历
        HeroNode temp = headNode;
        /*
        如果node.no = 0,，即node.no = headNode.no，无法添加
        */
        if (node.no == 0) {
            System.out.println("节点 no 不能等于0，无法添加");
            return;
        }

        while (temp.next != null) {
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("该节点已经存在，无法添加");
                break;
            }
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }

    /**
     * 遍历链表，从节点指向的节点开始输出
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

}
