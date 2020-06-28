package linkedlist.circlesinglylinked;

/**
 * 用单项循环链表解决约瑟夫循环问题
 */
public class JosephCircle {
    public static void main(String[] args) {
        CircleSinglyLinkedList csList = new CircleSinglyLinkedList();
        // 链表中节点数
        int circleLength = 100;
        // 退出链表的索引
        int quitIndex = 7;

        /*
        向链表中添加数据
         */
        for (int i = 1; i <= 100; i++) {
            Node node = new Node(i);
            csList.add(node);
        }

        Node lastNode = csList.josephCircle(7);
        System.out.println(lastNode.no);

        //csList.list();
    }
}
