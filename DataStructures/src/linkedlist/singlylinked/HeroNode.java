package linkedlist.singlylinked;

/**
 * @author admin
 * @ClassName HeroNode.java
 * @Description 链表节点类（以水浒传英雄为元素）
 * @createTime 2020年06月18日 23:01:00
 */
public class HeroNode {
    /**
     * 节点序号，用于排序
     */
    public int no;

    public String name;

    /**
     * 英雄昵称
     */
    public String nickName;

    /**
     * 指向下一节点
     */
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /*
    为了显示方便，重写toString方法
     */

    @Override
    public String toString() {
        return "HeroNode [no = " + no + ", name = " + name + ", nickName = " + nickName + "]";
    }
}
