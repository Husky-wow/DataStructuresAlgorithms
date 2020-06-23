package linkedlist.singlylinked;

/**
 * @author xuxd
 * @ClassName SinglyLinkedList.java
 * @Description 单向链表，每一个节点为一个HeroNode，存在一个无数据的头节点
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
     * 找到链表中 no为 node.no的节点，并将该节点更新
     * @param node
     */
    public void update(HeroNode node) {
        HeroNode temp = headNode;

        while (temp.next != null) {
            // temp后移
            temp = temp.next;
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                return;
            }
        }
        // temp.next == null时执行
        System.out.println("在当前链表中没有找到该节点，无法更新");
    }

    /**
     * 删除no节点
     * temp为待删除节点的前一个节点
     * temp.next = temp.next.next
     * @param no
     */
    public void delete(int no) {
        // 从头节点开始遍历
        HeroNode temp = headNode;

        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        System.out.println("没有找到可删除的节点");
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

    /**
     * 求链表倒数第k个元素
     *         1. 求出链表元素个数
     *         2. 求出倒数第k个元素的整数位置，以目前的思路，应该是 size() - k + 1;
     *         3. 从头遍历找到该元素
     * @param lastIndex 倒数第几个元素
     * @return
     */
    public HeroNode getLastIndex(int lastIndex) {
        int count = this.size();
        int index = count - lastIndex + 1;
        if (index <= 0) {
            System.out.println("该元素不存在");
            return null;
        }
        // 当前
        HeroNode current = headNode;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * 反转链表中的元素
     * 1. 新建一个头节点 reverseHead
     * 2. 从头遍历链表，将每一个遍历到的节点放置在reverseHead的后边（头插入法）
     * 3. head.next = reverseHead.next
     */
    public void reverseList() {
        // 如果链表仅有头结点，或者只有一个节点，无需反转，直接返回
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        // 当前正在遍历的节点
        HeroNode current = headNode.next;
        // 记录当前节点的下一个节点，否在在后边的过程中会丢失节点，链表断裂
        HeroNode next;
        // 新的头节点
        HeroNode revereHead = new HeroNode(0, "", "");

        /*
        遍历节点并移动
         */
        while (current != null) {
            // 先对next赋值，如果最后对next赋值，会多循环一次，并报空指针错误
            next = current.next;
            current.next = revereHead.next;
            revereHead.next = current;
            current = next;
        }

        headNode.next = revereHead.next;
    }

}
