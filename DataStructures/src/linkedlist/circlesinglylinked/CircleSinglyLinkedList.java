package linkedlist.circlesinglylinked;


public class CircleSinglyLinkedList {

    // first节点
    public Node firstNode =  null;

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node) {
        // 该单项循环列表中无节点
        if (firstNode == null) {
            firstNode = node;
            // 当仅有一个节点时，next指向自己，形成一个环
            firstNode.next = firstNode;
            return;
        }

        // 从第一个节点开始遍历寻找
        Node current = firstNode;
        // current.next != firstNode时未找到最后一个节点
        while (current.next != firstNode) {
            current = current.next;
        }

        /*
        找到最后一个节点
         */
        current.next = node;
        node.next = firstNode;
    }

    /**
     * 遍历该单向循环链表
     */
    public void list() {
        if (firstNode == null) {
            System.out.println("该CircleSinglyLinkedList中节点为空");
            return;
        }

        // 先打印firstNode节点
        int count = 1;
        System.out.printf("第 %d 个节点编号为：%d \n", count++, firstNode.no);

        // 从头结点的下一个节点开始遍历
        Node current = firstNode.next;

        // current != firstNode时未找到最后一个节点
        while (current != firstNode) {
            System.out.printf("第 %d 个节点编号为：%d \n", count++, current.no);
            current = current.next;
        }
    }

    /**
     * 约瑟夫循环
     * @param circleIndex 退出索引
     * @return 返回最后剩下的节点
     */
    public Node josephCircle(int circleIndex) {
        if (circleIndex <= 1) {
            System.out.println("circleIndex 有误");
        }

        if (firstNode == null) {
            System.out.println("该CircleSinglyLinkedList中节点为空");
            return null;
        }

        if (firstNode.next == firstNode) {
            System.out.println("该CircleSinglyLinkedList中仅有一个节点");
            return firstNode;
        }

        /*
        1. helper作为辅助变量，指向firstNode的前一个节点；
        2. 当helper.next == firstNode时，help节点为firstNode的前一个节点；
         */
        Node helper = firstNode;
        while (helper.next != firstNode) {
            helper = helper.next;
        }

        /*
        1. 开始循环报数；
        2. 每轮报数circleIndex-1次；
        4. 一轮报数结束后，移除firstNode指向节点；
        5. 当只剩一个节点时报数结束，即helper == firstNode；
        6. 注：如果报数circleIndex次，则将helper指向节点移除链表，当时此时不知道helper前一个节点
         */
        while (helper != firstNode) {
            for (int i = 1; i <= circleIndex - 1; i++) {
                firstNode = firstNode.next;
                helper = helper.next;
            }
            firstNode = firstNode.next;
            helper.next = firstNode;
        }

        return firstNode;
    }


}
