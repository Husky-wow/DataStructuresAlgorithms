package stack;

import java.util.Scanner;

/**
 * @author admin
 * @ClassName ArrayStackDemo.java
 * @Description TODO
 * @createTime 2020年06月28日 23:53:00
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("show, 显示栈中数据");
            System.out.println("push, 入栈");
            System.out.println("pop, 出栈");
            System.out.println("exit, 退出程序");

            String input = scanner.next();
            switch (input) {
                case "show":
                    try {
                        stack.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("输入入栈数据");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                    break;
                case "pop":
                    try {
                        int popValue = stack.pop();
                        System.out.println(popValue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
    }
}
