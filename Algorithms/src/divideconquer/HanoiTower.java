package divideconquer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 分治算法的经典实例：汉诺塔
 */
public class HanoiTower<T> {

    /**
     * 使用三个栈模拟三个柱子
     */
    public Deque<T> aStack = new ArrayDeque<>();
    public Deque<T> bStack = new ArrayDeque<>();
    public Deque<T> cStack = new ArrayDeque<>();

    /**
     * 使用分治算法解决汉诺塔问题,将所有盘子分为两部分，
     *  第一部分为第一个盘子到倒数第二个盘子，
     *  第二部分为最后一个盘子
     * 1. 将第一部分从 a -> b, 在整个过程中会用到c
     * 2. 将第二部分从 a -> c
     * 3. 将第一部分从 b -> c，移动过程中会用到a
     * @param num 盘子的数量
     * @param srcStack 源栈，从哪个柱子移动盘子
     * @param temStack 在盘子移动的过程中会暂时用到该柱子
     * @param dstStack 目标栈，从源柱子移动盘子到该柱子
     */
    public void hanoiTowerSolution(int num, Deque<T> srcStack, Deque<T> temStack, Deque<T> dstStack) {
        if (num == 1) {
            move(srcStack, dstStack);
        } else {
            // 1. 将第一部分从 a -> b, 在整个过程中会用到c
            hanoiTowerSolution(num - 1, srcStack, dstStack, temStack);
            // 2. 把最下边的盘子从 a -> c
            move(srcStack, dstStack);
            // 3. 把第一部分的盘子从 b -> c，在整个过程中会用到a
            hanoiTowerSolution(num - 1, temStack, srcStack, dstStack);
        }
    }

    private void move(Deque<T> srcStack, Deque<T> dstStack) {
        T pop = srcStack.pop();
        dstStack.push(pop);
    }
}
