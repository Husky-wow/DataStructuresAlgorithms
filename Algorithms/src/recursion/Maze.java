package recursion;

/**
 * @author admin
 * @ClassName Maze.java
 * @Description 使用递归回溯实现走迷宫
 * @createTime 2020年07月04日 00:13:00
 */
public class Maze {

    /**
     * 使用二维数组模拟地图
     *  1. 数字1代表墙；
     *  2. 数字2代表已经走过的点，经过该点可以继续向下走（注：一条能够走通的路上边的点数字都应该是2）；
     *  3. 数字3代表经过该点无法走通；
     */
    private int[][] map;

    /**
     * 起始位置
     */
    private Point startPoint;

    /**
     * 结束位置
     */
    private Point endPoint;

    public Maze(int[][] map , Point startPoint, Point endPoint) {
        this.map = map;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int[][] getMap() {
        return map;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void printMap() {
        if (map == null || map.length == 0) {
            System.out.print("map is empty");
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     ，
     * @param x
     * @param y
     * @return
     */
    /**
     * 走迷宫核心方法，递归使用该方法
     *  1. 递归方法需要找出递归结束条件，结束条件为point equals endPoint
     *  2. 从point点向下走时需要自定义一个规则，也可以说是走的方向
     *      我自定义的方向为：上 -> 下 -> 左 -> 右
     *      从这个点向下一个点走时向上走，如果不行就向下走，如果下走不通，就向左向右；
     *  3. 约定，当point点上其map[point.x][point.y]为
     *      0 表示该点还没走过，
     *      1 表示该点为墙，
     *      2 表示该点可以走过，暂时可以走通
     *      3 表示该点已经走过，被证实走不通
     *
     * @param point 要走的点，从递归角度，每一个传进来的point都能看做起始点
     * @return true 表示找到成功路径名
     *         false 表示没有找到成功路径
     */
    public boolean goMap(Point point) throws NullPointerException {
        if (endPoint.equals(point)) {
            // point 为结束点则表示走出迷宫，直接返回true，这也为递归结束条件
            map[endPoint.x][endPoint.y] = 2;
            return true;
        } else {
            if (map[point.x][point.y] == 0) {
                // 该点的值为0，说明该点还没有被走过,先假设该点可以走通，即将该点值置位2
                map[point.x][point.y] = 2;
                /*
                然后遵循自定义的规则继续走
                    1. 首先向上走，goMap(new Point(point.x, point.y - 1))
                        返回true表示该点作为起始点从向上走能够找到成功路径，返回true；
                        返回false表示该点作为起始点,向下走不可能找到成功路径，那么就向上走；
                    2. 向上走不通，同理，向下走goMap(new Point(point.x, point.y + 1))；
                    3. 向下走不通，同理，向左走goMap(new Point(point.x - 1, point.y))；
                    4. 向左走不通，同理，向右走goMap(new Point(point.x + 1, point.y))；
                    5. 上下左右都走不通，说明该点作为起始点最终找不到成功路径，直接返回false,并将该点置位3
                 */
                if (goMap(new Point(point.x - 1, point.y))) {
                    return true;
                } else if (goMap(new Point(point.x + 1, point.y))) {
                    return true;
                } else if (goMap(new Point(point.x, point.y - 1))) {
                    return true;
                } else if (goMap(new Point(point.x, point.y  + 1))) {
                    return true;
                } else {
                    map[point.x][point.y] = 3;
                    return false;
                }
            } else {
                // 该点的值不为0，即为1,2,3均表示该点不能走，直接返回false
                return false;
            }
        }
    }


}
