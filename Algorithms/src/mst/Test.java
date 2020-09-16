package mst;

/**
 * @author admin
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020年09月17日 00:24:00
 */
public class Test {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.data = new char[]{'A','B','C','D','E','F','G'};
        graph.vertex = graph.data.length;
        // 图的邻接矩阵，10000这个大数，表示两个点不联通
        graph.weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        // 使用Prim计算最小生成树
        graph.primMST();
    }

}
