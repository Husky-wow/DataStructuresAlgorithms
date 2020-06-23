package linkedlist.singlylinked;

/**
 * @author admin
 * @ClassName SinglyLinkedListDemo.java
 * @Description 单向链表测试类
 * @createTime 2020年06月18日 23:00:00
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        /*
        创建测试节点
         */
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        /*
        添加节点
         */
        /*singlyLinkedList.add(hero1);
        singlyLinkedList.add(hero6);
        singlyLinkedList.add(hero2);*/

        singlyLinkedList.addByOrder(hero1);
        singlyLinkedList.addByOrder(hero6);
        singlyLinkedList.addByOrder(hero2);

        HeroNode heroUpdate = new HeroNode(2, "大卢", "玉麒麟~~");

        singlyLinkedList.update(heroUpdate);

        singlyLinkedList.list();

        // 反转链表
        singlyLinkedList.reverseList();
        System.out.println("链表反转后~~~~");
        singlyLinkedList.list();

        /*System.out.println("链表节点更新后~~~");
        singlyLinkedList.list();

        singlyLinkedList.delete(2);
        System.out.println("删除2节点后~~");
        singlyLinkedList.list();*/

        int count = singlyLinkedList.size();
        System.out.println(count);


        // 求倒数第三个元素，k = 3
        HeroNode lastNode = singlyLinkedList.getLastIndex(1);
        System.out.println(lastNode.toString());

    }
}
