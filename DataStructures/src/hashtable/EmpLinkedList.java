package hashtable;

/**
 * 节点为雇员的链表,单向链表
 *  实现增删改查和遍历功能
 */
public class EmpLinkedList {

    /**
     * 头节点
     */
    private Emp head = new Emp(-1, null);

    /**
     * 往链表里添加元素
     *  按照id升序添加
     *  将目标节点添加至current和current.next中间
     * @param emp
     */
    public void add(Emp emp) {

        /*
        如果head.next == null
            直接添加到头节点之后
         */
        if (head.next == null) {
            head.next = emp;
            return;
        }

        Emp current = head.next;

        while (current.next != null) {
            if (emp.id > current.next.id) {
                break;
            } else if (emp.id == current.next.id){
                // 相等就更新替换
                emp.next = current.next.next;
                current.next = emp;
                return;
            } else {
                // emp.id < current.next.id 继续后移
                current = current.next;
            }
        }

        /*
        执行到这里分为两种情况
            1. current.next不为空，即找到插入位置
            2. current.next为空，遍历到链表最后一个位置，没找到插入位置，将其插入current.next
         */
        emp.next = current.next;
        current.next = emp;
    }

    /**
     * 根据id删除
     *  删除current.next
     * @param id
     */
    public void delete(int id) {
        if (head.next == null) {
            return;
        }

        Emp current = head;
        while (current.next != null) {
            if (id == current.next.id) {
                // 相等删除
                current.next = current.next.next;
                return;
            }
            // 找不到后移
            current = current.next;
        }
    }

    /**
     * 根据id获取Emp
     * @param id
     * @return
     */
    public Emp get(int id) {
        // 从头节点开始遍历
        if (head.next == null) {
            return null;
        }

        Emp current = head.next;
        while (current != null) {
            if (id == current.id) {
                return current;
            }
            current = current.next;
        }

        // 运行到这里以为这遍历到链表末端而且还没找到
        return null;
    }

    /**
     * 遍历链表
      */
    public void list() {
        // 从头节点开始遍历
        if (head.next == null) {
            System.out.print("没有元素");
            return;
        }

        /*
        从头节点开始遍历
         */
        Emp current = head.next;
        while (current != null) {
            System.out.print("==>" + current.toString() + "\t");
            current = current.next;
        }
    }



}
