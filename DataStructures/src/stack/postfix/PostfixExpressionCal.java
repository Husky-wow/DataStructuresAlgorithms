package stack.postfix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 后缀表达式(逆波兰式)计算
 */
public class PostfixExpressionCal {

    Deque<Integer> numStack = new ArrayDeque<>();

    /**
     * 计算后缀表达式
     *  字符串规格，为了防止数字之间冲突，数字和数字之间，数字和操作符之间使用空格作为分隔
     *
     *  1. 遍历字符串，得到数字和字符；
     *
     * @param postfixExpression
     * @return
     */
    public int calPostfixExpression(String postfixExpression) {

        if (postfixExpression == null || postfixExpression.equals("")) {
            throw new RuntimeException("postfixExpression is empty");
        }

        String[] strings = postfixExpression.split(" ");

        for (String item : strings) {
            // 匹配字符串是否为多个数字组成
            if (item.matches("\\d+")) {
                Integer num = Integer.valueOf(item);
                numStack.push(num);
            } else {
                cal(item);
            }
        }

        return numStack.pop();
    }

    public int calPostfixExpression(List<String> postfixList) {

        if (postfixList == null || postfixList.size() == 0) {
            throw new RuntimeException("postfixList is empty");
        }

        for (String item : postfixList) {
            // 匹配字符串是否为多个数字组成
            if (item.matches("\\d+")) {
                Integer num = Integer.valueOf(item);
                numStack.push(num);
            } else {
                cal(item);
            }
        }

        return numStack.pop();
    }

    private void cal(String operator) {
        Integer result;
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();
        switch (operator) {
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                throw new RuntimeException("操作符错误");
        }
        numStack.push(result);
    }

}
