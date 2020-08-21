package graph;

public class GraphWithAdjacentMatrixDemo {
    public static void main(String[] args) {
        // 图的顶点
        //String[] vertexes = {"A", "B", "C", "D", "E"};
        String[] vertexes = {"1", "2", "3", "4", "5", "6", "7", "8"};
        // 图中顶点的个数
        int edgeCount = 8;
        GraphWithAdjacentMatrix graph = new GraphWithAdjacentMatrix(edgeCount);

        /*
        向图中添加顶点
         */
        for (int i = 0; i <vertexes.length ; i++) {
            graph.addVertex(vertexes[i]);
        }

        /*
        添加边
         */
        /*graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);*/
        graph.addEdges(0,1, 1);
        graph.addEdges(0,2, 1);
        graph.addEdges(1,3, 1);
        graph.addEdges(1,4, 1);
        graph.addEdges(3,7, 1);
        graph.addEdges(4,7, 1);
        graph.addEdges(2,5, 1);
        graph.addEdges(2,6, 1);
        graph.addEdges(5,6, 1);

        graph.showGraph();

        // 深度优先遍历 1 -> 2 -> 4 -> 8 -> 5 -> 3 -> 6 -> 7
        System.out.println("深度优先遍历图");
        graph.dfs();
        System.out.println();

        // 广度优先遍历 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        System.out.println("广度优先遍历图");
        graph.bfs();
        System.out.println();

    }
}
