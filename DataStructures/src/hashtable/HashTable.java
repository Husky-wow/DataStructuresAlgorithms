package hashtable;

/**
 * 写一个简单的哈希表
 *  数组 + 链表
 *      仅有增删改查功能
 */
public class HashTable {

    private EmpLinkedList[] empLinkedListArr;

    public HashTable() {
        // 初始默认长度为10
        // 讲道理，哈希表的数组长度应该为2的次幂，但是此处是练习并模拟哈希表结构，并且是根据Emp.id来计算，因为做简化
        empLinkedListArr = new EmpLinkedList[10];
        for (int i = 0; i <empLinkedListArr.length ; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    /**
     * 散列函数：将id转换为数组下标
     *  最简单的方法，取模
     *  10个元素 所以 %10，其实是根据id个位的值，个位为0存入下标为0，个位为1存入下标1，依次类推
     * @param id
     * @return
     */
    private int hashFun(int id) {
        return id % 10;
    }

    /**
     * 向HashTable中放置元素
     *  如果不存在，找到位置放置
     *  如果存在，更新
     * @param emp
     */
    public void put(Emp emp) {
        if (emp == null) {
            System.out.println("目标节点为空，不能添加");
            return;
        }

        int index = hashFun(emp.id);
        empLinkedListArr[index].add(emp);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void delete(int id) {
        int index = hashFun(id);
        empLinkedListArr[index].delete(id);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Emp get(int id) {
        int index = hashFun(id);
        Emp result = empLinkedListArr[index].get(id);

        return result;
    }

    /**
     * 遍历HashTable
     */
    public void list() {
        for (int i = 0; i < empLinkedListArr.length; i++) {
            EmpLinkedList linkedList = empLinkedListArr[i];
            System.out.printf("HashTable-索引为%d: ", i);
            linkedList.list();
            System.out.println();
        }
    }
}
