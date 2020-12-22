package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @ClassName CoinProblem.java
 * @Description 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1
 * @createTime 2020年12月23日 00:12:00
 */
public class CoinProblem {
    public static void main(String[] args) {
        int[] coin = {1, 2, 5};
        int n = 11;

        CoinProblem coinProblem = new CoinProblem();
        int i = coinProblem.coinProblem1(coin, n);
        System.out.println(i);
    }

    /**
     * 递归解法
     * @param coin k种面值的硬币数组
     * @param n 总金额
     * @return 返回结果
     */
    public int coinProblem1(int[] coin, int n) {
        if (n <= 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coin.length; i++) {
            if (n - coin[i] < n) {
                continue;
            }
            int result = 1 + coinProblem1(coin, n - coin[i]);
            if (result < min) {
                min = result;
            }
        }
        return min;
    }

    /**
     * TODO带备忘录的递归算法
     * @param coin
     * @param n
     * @return
     */
    public int coinProblem2(int[] coin, int n) {
        if (n <= 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coin.length; i++) {
            if (n - coin[i] < n) {
                continue;
            }
            int result = 1 + coinProblem2(coin, n - coin[i]);
            if (result < min) {
                min = result;
            }
        }
        return min;
    }
}
