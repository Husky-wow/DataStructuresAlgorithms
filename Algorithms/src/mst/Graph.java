package mst;

/**
 * @author admin
 * @ClassName PrimAlgorithms.java
 * @Description 普利姆算法解决修路问题，即用Prim算数对图生成一个“最小生成树”，又叫该图的“极小连通子图”
 *
 * Minimum Spanning Tree,MST 最小生成树
 *
 * 为了突出重点，省去图的生成过程
 * @createTime 2020年09月16日 23:37:00
 */
public class Graph {

    /**
     * 图的顶点个数
     */
    public int vertex;

    /**
     * 记录顶点编号
     */
    public char[] data;

    /**
     * 记录顶点之间连通路径权值
     */
    public int[][] weight;

    /**
     * 利用普利姆计算最小生成树
     */
    public void primMST() {

        // 该数组记录顶点是否被访问
        int[] visited = new int[vertex];

        // 使用两个数记录找到两个顶点
        int v1 = 0;
        int v2 = 0;

        // 记录找到的最小权重
        int minWeight = 10000;

        // 以第一个顶点作为起点找寻
        visited[0] = 1;

        /*
        n个顶点至少需要n-1条边才能连通每一个顶点,因此外层循环循环次数为vertex - 1次
         */
        for (int k = 1; k < vertex; k++) {
            /*
            下边的两个循环的目的：
                1. 找到已经被访问的所有节点（visited[i]==1）；
                2. 找到和已经被访问的节点能够连通的没有被访问的节点（visited[j]==0）中路径权值最小的节点（weight[i][j] < minWeight）
                注：当weight[i][j]<10000表示该两个节点之间能被连通，第一次找到符合的值将其赋给minWeight，后边找到更小的，覆盖
             */
            for (int i = 0; i < vertex; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < vertex; j++) {
                        if (visited[j] == 0 && weight[i][j] < minWeight) {
                            minWeight = weight[i][j];
                            v1 = i;
                            v2 = j;
                        }
                    }
                }
            }
            /*
            执行到这里表示找到一条边,执行下列步骤
                1. 将v2顶点至为已访问
                2. 做一个输出
                3. 重置minWeight
             */
            visited[v2] = 1;
            System.out.println("边<" + data[v1] + "," + data[v2] + "> 权值:" + minWeight);
            minWeight = 10000;
            System.out.println("~~~~~~~~~~~");
        }
    }


}
