package linkedlist;

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

        singlyLinkedList.list();

        HeroNode heroUpdate = new HeroNode(2, "大卢", "玉麒麟~~");
        singlyLinkedList.update(heroUpdate);

        System.out.println("链表节点更新后~~~");
        singlyLinkedList.list();
    }
}
