package stack;

/**
 * @author admin
 * @ClassName Calculator.java
 * @Description 使用栈去实现简单计算器功能
 *      0. 输入一个字符串，为计算式
 *      1. 需要两个栈：一个栈存放数字，一个栈存放操作符
 *      2. 当向操作符栈存放操作符时，比较需要存入的操作符和栈顶的操作符
 *          如果当前操作符的优先级 <= 栈顶的操作符，弹出数字栈中的两个数字，弹出操作符栈中的操作符，做运算，将结果存入数字栈，将需要存入的操作符存入操作符栈
 *          如果当前操作符的优先级 > 栈顶的操作符，正常存入
 *      3. 字符串中的数字和操作符都存入栈中后，进行计算
 * @createTime 2020年06月29日 22:45:00
 */
public class Calculator {

    /**
     * 数字栈
     */
    private ArrayStack numStack = new ArrayStack(20);

    /**
     * 操作符栈
     */
    private ArrayStack operaStack = new ArrayStack(20);

    public ArrayStack getNumStack() {
        return numStack;
    }

    public ArrayStack getOperaStack() {
        return operaStack;
    }

    /**
     * 计算
     * @param inputStr
     * @return
     */
    public int calculation(String inputStr) {
        inputStr = inputStr.trim();
        /*
        遍历字符串中的每个字符，分别获取数字和字符
            使用两个索引值辅助遍历
            0. 从0开始；
            1. 如果tempChar为运算符,截取[starIndex，endIndex)之间的字符串，将其转换为数字，
                然后endIndex后移一位，starIndex和endIndex指向同一位
                最后将当前位置的运算符存入栈（需要判断）
            2. 如果tempChar为数字，starIndex不变，endIndex后移一位
         */
        int starIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            char tempChar = inputStr.charAt(i);
            if (tempChar == '+' || tempChar == '-' || tempChar == '*' || tempChar == '/') {
                String numStr = inputStr.substring(starIndex, endIndex);
                int num = Integer.parseInt(numStr);
                pop(num, tempChar);
                endIndex++;
                starIndex = endIndex;
            } else {
                endIndex++;
            }
        }

        // 处理最后一个数字
        if (starIndex != endIndex) {
            String numStr = inputStr.substring(starIndex, endIndex);
            int num = Integer.parseInt(numStr);
            numStack.push(num);
        }

        return 0;
    }


    //数字和操作符入栈
    private void pop(int num, int operator) {
        numStack.push(num);
        // 如果操作符入栈失败，即当前操作符的优先级 <= 栈顶的操作符
        if (!operaStack.pushOperator(operator)) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char operaChar = (char) operaStack.pop();
            int result = cal(num1, num2, operaChar);
            numStack.push(result);
            operaStack.push(operator);
        }
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param operaChar
     * @return
     */
    private int cal(int num1, int num2, char operaChar) {
        int result = 0;
        switch (operaChar) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                throw new RuntimeException("无法计算，操作符出错");
        }

        return result;
    }

}
