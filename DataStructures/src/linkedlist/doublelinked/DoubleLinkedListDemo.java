package linkedlist.doublelinked;

/**
 * @author admin
 * @ClassName DoubleLinkedListDemo.java
 * @Description 双向链表测试类
 * @createTime 2020年06月23日 21:58:00
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        /*
        创建测试节点
         */
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        /*
        添加节点
         */
        /*doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero6);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        System.out.println("添加节点");
        doubleLinkedList.list();*/

        /*
        按顺序添加节点
         */
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero6);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        System.out.println("按顺序添加节点");
        // 打印链表各节点
        doubleLinkedList.list();
        System.out.println(doubleLinkedList.size());

        /*
        更新节点
         */
        HeroNode heroUpdate = new HeroNode(2, "大卢", "玉麒麟~~");
        doubleLinkedList.update(heroUpdate);
        System.out.println("更新编号为2的节点后");
        doubleLinkedList.list();
        System.out.println(doubleLinkedList.size());

        /*
        删除节点
         */
        doubleLinkedList.delete(2);
        System.out.println("删除编号为2的节点后");
        doubleLinkedList.list();
        System.out.println(doubleLinkedList.size());
    }

}
