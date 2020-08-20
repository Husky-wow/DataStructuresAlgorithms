package graph;

public class GraphWithAdjacentMatrixDemo {
    public static void main(String[] args) {
        // 图中顶点的个数
        int edgeCount = 5;

        GraphWithAdjacentMatrix graph = new GraphWithAdjacentMatrix(edgeCount);
        // 图的顶点
        String[] vertexes = {"A", "B", "C", "D", "E"};
        /*
        向图中添加顶点
         */
        for (int i = 0; i <vertexes.length ; i++) {
            graph.addVertex(vertexes[i]);
        }

        /*
        添加边
         */
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);

        graph.showGraph();
    }
}
