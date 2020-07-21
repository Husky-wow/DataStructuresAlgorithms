package hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        Emp emp1 = new Emp(1, "宋江");
        Emp emp2 = new Emp(2, "卢俊义");
        Emp emp11 = new Emp(11, "我也不知道啥名");

        hashTable.put(emp1);
        hashTable.put(emp2);
        hashTable.put(emp11);
        hashTable.list();

        System.out.println("~~~~~~~~~~~~~~~~~替换~~~~~~~~~~~~~~~~~");
        hashTable.put(new Emp(11, "李应"));
        hashTable.list();

        /*System.out.println("~~~~~~~~~~~~~~~~~删除不存在的元素~~~~~~~~~~~~~~~~~");
        hashTable.delete(10);
        hashTable.list();

        System.out.println("~~~~~~~~~~~~~~~~~删除存在的元素~~~~~~~~~~~~~~~~~");
        hashTable.delete(1);
        hashTable.list();*/

        System.out.println("~~~~~~~~~~~~~~~~~查找存在元素~~~~~~~~~~~~~~~~~");
        Emp result = hashTable.get(11);
        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("不存在该元素");
        }

        System.out.println("~~~~~~~~~~~~~~~~~查找不存在元素~~~~~~~~~~~~~~~~~");
        Emp result2 = hashTable.get(10);
        if (result2 != null) {
            System.out.println(result2.toString());
        } else {
            System.out.println("不存在该元素");
        }

    }
}
