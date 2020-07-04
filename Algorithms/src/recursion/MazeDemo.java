package recursion;

public class MazeDemo {
    public static void main(String[] args) {
        int[][] map = initMazeMap();
        Maze maze = new Maze(map, new Point(1, 1), new Point(6, 5));
        System.out.println("寻找路径前迷宫");
        maze.printMap();
        boolean result = maze.goMap(maze.getStartPoint());
        if (result) {
            System.out.println("寻找路径成功，并打印迷宫");
        } else {
            System.out.println("寻找路径失败，并打印迷宫");
        }
        maze.printMap();
    }

    /**
     * 初始化一个迷宫地图
     */
    private static int[][] initMazeMap() {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        return map;
    }
}
