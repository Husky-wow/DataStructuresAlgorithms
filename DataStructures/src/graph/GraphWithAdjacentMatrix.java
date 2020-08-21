package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用邻接矩阵实现的图
 */
public class GraphWithAdjacentMatrix {

    /**
     * 使用List存放定点，顶点的值为字符串A、B、C...
     */
    public List<String> vertexList = new ArrayList<>();

    /**
     * 记录每个顶点是否在遍历的过程中被访问过，false表示没有，true表示已经被访问过
     */
    public boolean[] vertexIsVisited;

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
    public String getVertexStrByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 获取顶点在邻接矩阵中的索引值
     * @param vertex 顶点
     * @return 顶点在邻接矩阵中的索引值
     */
    public int getVertexIndexByStr(String vertex) {
        if (vertexList.contains(vertex)) {
            return vertexList.indexOf(vertex);
        }

        return -1;
    }

    /**
     * 获取索引值为index的顶点的第一个邻接顶点
     * @param index 顶点的索引值
     * @return 第一个邻接顶点的索引值, 返回-1则表示该顶点没有邻接顶点
     */
    public int getFirstAdjacentVertex(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        // 执行到这里表示没有找到索引值为index的顶点的邻接顶点
        return -1;
    }

    /**
     * 获取索引值为index的顶点的下一个邻接顶点
     * @param index 顶点的索引值
     * @param adjacentVertexIndex 顶点的当前邻接顶点
     * @return 返回下一个邻接顶点
     */
    public int getNextAdjacentVertex(int index, int adjacentVertexIndex) {
        // 因为是下一个邻接顶点，因此从当前邻接顶点索引值 + 1处开始遍历
        for (int i = adjacentVertexIndex + 1; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }

        // 执行到这里表示没有找到索引值为index的顶点的下一个邻接顶点
        return -1;
    }

    /**
     * 深度优先遍历depth-first search
     * @param vertexIndex 正在被遍历的顶点的索引值
     */
    private void dfs(int vertexIndex) {
        // 先输出该顶点
        System.out.print(getVertexStrByIndex(vertexIndex) + " -> ");
        // 1. 将该顶点置位以访问
        vertexIsVisited[vertexIndex] = true;
        // 2. 找到该顶点的第一个邻接顶点的索引值
        int adjacentVertex = getFirstAdjacentVertex(vertexIndex);
        while (adjacentVertex != -1) {
            // 3. firstAV != -1 表示找到第一个邻接顶点，判断该顶点是否被访问过
            if (!vertexIsVisited[adjacentVertex]) {
                // 4. 如果没有被访问过，则继续深度遍历索引值为firstAV的顶点
                dfs(adjacentVertex);
            }
            // 5. 如果被访问过，就继续找vertexIndex的下一个邻接顶点
            adjacentVertex = getNextAdjacentVertex(vertexIndex, adjacentVertex);
        }
        // 跳出while循环后，表示索引值为verIndex的顶点没有邻接顶点了，
        // 那这时存在一个问题：如果某一个顶点它就是没有邻接顶点，比如说不连通图
        // 那这时仅有这一个方法，必然无法将所以顶点完全遍历，因此外部需要一个方法去遍历所有的顶点，防止上述情况的存在
    }

    /**
     * 对外提供的深度遍历的方法，该方法的作用：
     *  1. 为了更好的使用递归
     *  2. 为了避免上述的不连通图无法完全遍历的问题
     */
    public void dfs() {
        vertexIsVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!vertexIsVisited[i]) {
                // 如果该节点没有被访问过，则遍历该节点
                dfs(i);
            }
        }
    }

    /**
     * 广度优先搜索 breadth-first search
     * @param vertexIndex 从vertexIndex顶点开始遍历
     */
    private void bfs(int vertexIndex) {
        // 输出该顶点
        System.out.print(getVertexStrByIndex(vertexIndex) + " -> ");
        // 将该顶点的状态置为已经访问
        vertexIsVisited[vertexIndex] = true;
        // 用LinkedList模拟队列，队列中存放的顶点都是已经被访问过的顶点
        LinkedList<Integer> linked = new LinkedList<>();
        // 使用队列存放本次遍历中已经访问过的顶点
        linked.addLast(vertexIndex);
        /*
        队列不为空就一直可以遍历
         */
        while (!linked.isEmpty()) {
            // 1. 取出队头的顶点, u表示其索引
            int u = linked.removeFirst();
            // 2. 找出该顶点的第一个邻接顶点
            int v = getFirstAdjacentVertex(u);
            // v != -1 表示找到 u 顶点的第一个邻接顶点
            while (v != -1) {
                // 如果该顶点没有被访问过
                if (!vertexIsVisited[v]) {
                    // 3.1 打印该顶点
                    System.out.print(getVertexStrByIndex(v) + " -> ");
                    // 3.2 设置该顶点的状态为已访问
                    vertexIsVisited[v] = true;
                    // 3.3 把 v 顶点入队列
                    linked.addLast(v);
                }
                // 4 v顶点已经被访问过，或者3步骤中访问完成v顶点继续找 u 顶点的下一个邻接顶点
                v = getNextAdjacentVertex(u, v);
                // 当找不到u的下一个邻接顶点就会跳出内存while循环
            }
            // 当跳出内层循环后会去判断队列是否为空，对列不为空就取出对头顶点，继续遍历
            // 如果在dfs中所描述那样，会存在不连通图的情况，如果仅有这一个方法，无法遍历不连通的节点
            // 因此外部还需要一个方法
        }
    }

    /**
     * 对外提供的breadth-first search方法
     */
    public void bfs() {
        vertexIsVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!vertexIsVisited[i]) {
                bfs(i);
            }
        }
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
