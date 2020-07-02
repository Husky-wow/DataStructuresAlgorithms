package stack.postfix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 中缀表达式转换为后缀表达式
 *
 * 1. 需要连个两个栈s1和s2分别用于存放操作符和中间值;
 * 2. 从左至右顺序遍历中缀表达式字符串
 * 3. 如果是数字，则直接入栈 s2；
 * 4. 如果是运算符：
 *      4.1 如果 s1栈为空 or 栈顶为 ‘（ ’ 直接入栈 s1；
 *      4.2 如果优先级 > 栈顶运算符的优先级，直接入栈 s1；
 *      4.3 否则，将 s1 栈顶的运算符弹出并入栈 s2，然后继续执行步骤4.1;
 * 5. 如果是括号：
 *      5.1 左括号 ‘（’，直接入栈 s1；
 *      5.2 右括号 ')',  则依次弹出 s1 栈顶元素并入栈 s2，直到遇到左括号为止，此时将这一对括号丢弃；
 * 6. 重复步骤 2~5，直至到表达式的最右边；
 * 7. 将 s1 中剩余运算符弹出并入栈 s2；
 * 8. 依次弹出 s2 中的压元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 *
 *
 * 注：
 *  1. 直接遍历中缀表达式字符串效率不高，因此现将中缀表达式中的数字和操作符读出并存储至List；
 *  2. 总结上述步骤发现，s2 栈仅在最后一步弹出，并且还要逆序，
 *      因此，可用List代替 s2栈，并最后顺序遍历List，拼接组成最终字符串；
 */
public class Infix2PostExpression {

    /**
     * 将中缀表达式字符串转换为List
     * @param infixExpression 中缀表达式字符串
     * @return 返回中缀表达式List
     */
    public static List<String> infixString2List(String infixExpression) {
        if (infixExpression == null || infixExpression.equals("")) {
            throw new RuntimeException("传入中缀表达式错误");
        }

        List<String> resultList = new ArrayList<>();
        // 记录数字开始的索引
        int startIndex = 0;
        StringBuffer numStr = new StringBuffer();

        for (int i = 0; i < infixExpression.length(); i++) {
            char a = infixExpression.charAt(i);
            if (a <= '9' && a >= '0') {
                numStr.append(a);
            } else if (a == '+' || a == '-' || a == '*' || a == '/' || a == '(' || a == ')') {
                if (numStr.length() != 0) {
                    // 该操作符前有数字,将数字存起来
                    resultList.add(String.valueOf(numStr));
                    // 清空 StringBuffer 用来存放下一个数字
                    numStr.delete(0, numStr.length());
                }

                resultList.add(String.valueOf(a));
            }
        }

        // 最后一个数字
        if (numStr.length() != 0) {
            resultList.add(String.valueOf(numStr));
            numStr.delete(0, numStr.length());
            numStr = null;
        }

        return resultList;
    }

    /**
     * 将中缀表达式List转换为后缀表达式List
     * @param infixList 中缀表达式List
     * @return 后缀表达值List
     */
    public static List<String>  infix2Postfix(List<String> infixList) {
        if (infixList == null || infixList.size() == 0) {
            throw new RuntimeException("传入中缀表达式List有误");
        }

        Deque<String> s1 = new ArrayDeque<>();
        List<String> s2 = new ArrayList<>();

        for (String item : infixList) {
            if (item.matches("\\d+")) {
                // 数字，直接入 s2
                s2.add(item);
            } else if (isArithmeticOperator(item)) {
                /*
                4. 为算术运算符
                 */
                boolean loop = true;
                while (loop) {
                    if (s1.isEmpty() || "(".equals(s1.peek())) {
                        // 4.1 s1 栈为空 or s1 栈顶为 ( ，直接入 s1 栈
                        s1.add(item);
                        loop = false;
                    } else if (getPriority(item) > getPriority(s1.peek())) {
                        // 4.2 优先级 > 栈顶运算符的优先级，直接入栈 s1
                        s1.add(item);
                        loop = false;
                    } else {
                        // 4.3
                        s2.add(s1.pop());
                    }
                }
            } else if ("(".equals(item)) {
                // 5.1 左括号直接入 s1栈
                s1.push(item);
            } else if (")".equals(item)) {
                while (!"(".equals(s1.peek()) ) {
                    s2.add(s1.pop());
                }
                s1.pop();
            }
        }

        // 将 s1 中剩余运算符弹出并入栈 s2
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }

        return s2;
    }

    /**
     * 判断字符串是不是算术运算符
     * @param item
     * @return
     */
    private static boolean isArithmeticOperator(String item) {
        boolean result = false;
        switch (item) {
            case "+":
            case "-":
            case "*":
            case "/":
                result = true;
                break;
            default:
                break;
        }

        return result;
    }

    /**
     * 或者算术运算符的优先级
     * @param item
     * @return
     */
    private static int getPriority(String item) {
        int priority = -1;
        switch (item) {
            case "+":
            case "-":
                priority = 1;
            case "*":
            case "/":
                priority = 2;
                break;
            default:
                break;
        }

        return priority;
    }





}
