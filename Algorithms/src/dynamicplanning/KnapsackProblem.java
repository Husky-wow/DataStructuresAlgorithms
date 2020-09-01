package dynamicplanning;

/**
 * 使用动态规划解决背包问题
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        // 每个商品的重量, 数组下标对应商品的索引，为了方便，将下标为0位置不放置商品
        int[] w = {0, 1, 4, 3};

        // 每个商品的价值，数组下标对应商品的索引，为了方便，将下标为0位置不放置商品
        int[] val = {0, 1500, 3000, 2000};

        // 背包的容量
        int capacity = 4;

        // 商品的数量
        int shopCount = val.length - 1;

        // 用于记录结果的二维数组，因为数组索引从0开始，所以要 +1
        int[][] v = new int[shopCount + 1][capacity + 1];

        // path[i][j] = 1 表示索引为i的商品在重量为j的情况下有存入
        int[][] path = new int[shopCount + 1][capacity + 1];

        // j表示容量，容量为1开始
        for (int j = 1; j < v[0].length; j++) {
            // i 表示商品的索引
            for (int i = 1; i < v.length; i++) {
                if (w[i] > j) {
                    // 如果索引为i的商品重量超出当前的容量(不装入该商品时的最佳方案)
                    v[i][j] = v[i - 1][j];
                } else {
                    /*
                    如果索引为i的商品重量 < =当前的容量取两者中的较大值
                        1. 不装入该商品：该容量下，不装入该商品时的最优解 - v[i - 1][j]
                        2. 装入该商品：装入该商品后，剩余的重量装入其他商品时的最优解 + 该商品的价值
                     */

                    //v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - w[i]] + val[i]); // 该种写法只能找到最优解，但是无法知道最优解对应的方案
                    if (v[i - 1][j] >= v[i - 1][j - w[i]] + val[i]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = v[i - 1][j - w[i]] + val[i];
                        path[i][j] = 1;
                    }
                }
            }
        }

        /*
        倒序输出，计算方案；这是因为最佳方案在表的最后
         */
        int row = v.length - 1;
        int column = v[0].length - 1;
        while (row >= 0 && column >= 0) {
            if (path[row][column] == 1) {
                System.out.printf("第 %d 个商品加入背包\n", row);
                column -= w[row];
            }
            row--;
        }

        /*
        打印结果集
         */
        System.out.println("打印结果集~~~~~");
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
