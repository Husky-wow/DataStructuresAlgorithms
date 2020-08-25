package divideconquer;

public class DivideAndConquerDemo {

    public static void main(String[] args) {
        HanoiTower<Integer> integerHanoiTower = new HanoiTower<>();
        // 给a柱子加入盘子
        int count = 16;
        for (int i = count; i >=1 ; i--) {
            integerHanoiTower.aStack.push(i);
        }

        // 输出柱子内容
        System.out.println("a柱子" + integerHanoiTower.aStack);
        System.out.println("b柱子" + integerHanoiTower.bStack);
        System.out.println("c柱子" + integerHanoiTower.cStack);

        integerHanoiTower.hanoiTowerSolution(count, integerHanoiTower.aStack, integerHanoiTower.bStack, integerHanoiTower.cStack);

        // 输出移动后3个柱子的内容
        System.out.println();
        System.out.println("移动后~~~~~~~~~~");
        System.out.println("a柱子" + integerHanoiTower.aStack);
        System.out.println("b柱子" + integerHanoiTower.bStack);
        System.out.println("c柱子" + integerHanoiTower.cStack);
    }


}
