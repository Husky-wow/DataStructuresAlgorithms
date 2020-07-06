package recursion.eightqueen;

/**
 * @author admin
 * @ClassName EightQueenTest.java
 * @Description TODO
 * @createTime 2020年07月06日 23:28:00
 */
public class EightQueenTest {
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        // 从第0个棋子开始摆放
        eightQueen.check(0);
        System.out.println("正确解法的个数：" + eightQueen.count);
    }
}
