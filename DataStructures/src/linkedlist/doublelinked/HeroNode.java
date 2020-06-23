package linkedlist.doublelinked;

/**
 * @author admin
 * @ClassName HeroNode.java
 * @Description 双向链表节点类
 * @createTime 2020年06月23日 21:43:00
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
     * 下一节点
     */
    public HeroNode next;

    /**
     * 前一节点
     */
    public HeroNode pre;

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
