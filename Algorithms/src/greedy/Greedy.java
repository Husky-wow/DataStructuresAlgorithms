package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 *  该例中解决电台选择问题
 */
public class Greedy {

    public static void main(String[] args) {
        //创建广播电台,放入到Map, key值为电台，value为该电台覆盖城市的set集合
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区，当选择一个电台后，会从该集合中去除选择电台覆盖的的城市，即该Set存放的是未覆盖区域
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        // 存放选择的电台
        ArrayList<String> selects = new ArrayList<>();

        // 存放当前遍历的电台覆盖的区域和已选择电台未覆盖区域的交集，其实就是通过上述交集去计算当前遍历的电台还能够覆盖几个未覆盖区域
        HashSet<String> tempSet = new HashSet<>();

        // 在遍历的过程中用于存放当前情况下的最优选择
        String maxKey = null;
        // 用于记录在遍历过程中当前选择的maxKey覆盖的地区能够覆盖未被覆盖地区的个数
        int maxKeySize = 0;

        // 当前的写法其实有个条件就是最终选择的电台能够覆盖全部区域
        // 这个就是因题而定，如果该题中的电台并没有覆盖全部区域，那么该while就会陷入死循环
        while (allAreas.size() != 0) {
            maxKey = null;
            // 通过for循环遍历每一个电台，求出该电台能够覆盖几个未覆盖区域，找出能够覆盖最多未覆盖区域的那个电台
            for (String key : broadcasts.keySet()) {
                // 首先清除tempSet
                tempSet.clear();
                // 当前遍历的电台覆盖的区域
                HashSet<String> area = broadcasts.get(key);
                // 将area元素全部存入tempSet,不然无法调用retainAll求交集
                tempSet.addAll(area);
                // 求当前遍历的电台覆盖的区域和未覆盖的区域的交集，即计算当前遍历的电台能覆盖多少未覆盖区域
                tempSet.retainAll(allAreas);
                // 如果当前选择的电台能够覆盖的未被覆盖区域比目前选择的maxKey覆盖的未被覆盖区域多，就重置maxKey
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > maxKeySize)) {
                    maxKey = key;
                    maxKeySize = tempSet.size();
                }
            }
            if (maxKey != null) {
                // 选出maxKey
                selects.add(maxKey);
                // 将maxKey电台覆盖的区域从allAreas移除
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("最终的选择结果是：" + selects);
    }
}
