package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用邻接矩阵实现的图
 */
public class GraphWithAdjacentMatrix {

    /**
     * 使用List存放定点，顶点的值为字符串A、B、C...
     */
    public List<String> vertexList = new ArrayList<>();;

    /**
     * 使用int数组存放边，0表示两个顶点之间无连接
     */
    public int[][] edges;

    /**
     * 边的数量
     */
    public int edgesCount = 0;

    /**
     * 有参构造
     * @param count 顶点的个数
     */
    public GraphWithAdjacentMatrix(int count) {
        edges = new int[count][count];
    }

    /**
     * 向vertexList中添加顶点，该处顶点用A、B、C...表示
     * 其在邻接矩阵中对应的索引为0/1/2/3...
     * @param vertex 顶点
     */
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 获取邻接矩阵索引对应的顶点
     * @param index 邻接矩阵索引
     * @return 邻接矩阵索引对应的顶点
     */
    public String getIndexVertex(int index) {
        return vertexList.get(index);
    }

    /**
     * 获取顶点在邻接矩阵中的索引值
     * @param vertex 顶点
     * @return 顶点在邻接矩阵中的索引值
     */
    public int getVertexIndex(String vertex) {
        if (vertexList.contains(vertex)) {
            return vertexList.indexOf(vertex);
        }

        return -1;
    }

    /**
     * 向邻接矩阵中添加边
     * @param v1 顶点1索引
     * @param v2 顶点2索引
     * @param weight 边的权重
     */
    public void addEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        // 邻接矩阵是对称矩阵
        edges[v2][v1] = weight;
        edgesCount++;
    }

    /**
     * 输出邻接矩阵
     */
    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
