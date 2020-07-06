package recursion.eightqueen;

import java.util.Arrays;

/**
 * @author admin
 * @ClassName EightQueen.java
 * @Description 使用递归回溯解决八皇后问题，如果不知道八皇后问题，请百度
 * @createTime 2020年07月06日 22:54:00
 */
public class EightQueen {

    /**
     * 正确解法的个数
     */
    public int count = 0;

    /**
     * 列数
     */
    private int max = 8;

    /**
     * 使用一维数组实现8皇后的遍历问题
     *  数组的索引位置表示第几个棋子，也可以认为是二维数组的行坐标
     *  该索引位置的数值表示该棋子放置在该行第几列，也可以认为是二维数组的列坐标
     * 这样就通过一位数组实现了二维数组的功能
     */
    private int[] resultArray = new int[max];

    /**
     * 判断第 n个棋子拜访的位置是否正确
     * @param n 棋子的序号
     * @return
     */
    private boolean isCorrectPosition(int n) {

        // 分别和每个棋子的位置做对比
        for (int i = 0; i < n; i++) {
            /*
            1. resultArray[i] == resultArray[n] 第 i 个棋子和第 n 个棋子在同一列；
            2. Math.abs(n - i) == Math.abs(resultArray[n] - resultArray[i]) 第 i 个棋子和第 n 个棋子在同一条斜线；、
                2.1 两个棋子在一条斜线上，想象一个二维坐标，棋盘上的所以点组成起来就是一个正方形，
                    如果两个点在同一条线上，那么这两个点组成的直线其斜率为1；
             */
            if (resultArray[i] == resultArray[n]
                    || Math.abs(n - i) == Math.abs(resultArray[n] - resultArray[i])) {
                return  false;
            }
        }

        return true;
    }

    /**
     * 打印正确的结果
     */
    private void printCorrectResult() {
        count++;
        System.out.println(Arrays.toString(resultArray));
    }

    /**
     * 找寻第 n 个棋子可以摆放的位置，n从0开始
     * @param n
     */
    public void check(int n) {
        if (n == max) {
            // 当 n == max 时表示8个棋子已经摆放完毕，return向前回溯，寻找其他解法
            printCorrectResult();
            return;
        } else {
            // 循环遍历，第n个棋子寻找正确的摆放位置，每个棋子从第0列开始摆放
            for (int i = 0; i < max; i++) {
                // 第n个棋子摆放在第i列
                resultArray[n] = i;
                // 判断第n个棋子摆放到第i行是否正确
                if (isCorrectPosition(n)) {
                    // 如果正确，摆放第n+1个棋子
                    check(n + 1);
                }
                // 如果摆放不正确，for循环继续执行，将第n个棋子摆放到第i+1行
            }
        }
    }
}
