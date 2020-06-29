package stack;

/**
 * @author admin
 * @ClassName ArrayStack.java
 * @Description 数组模拟栈
 * @createTime 2020年06月28日 23:38:00
 */
public class ArrayStack {

    /**
     * 栈顶
     */
    public int top = -1;

    /**
     * 栈的大小
     */
    public int maxSize;

    /**
     * 数组模拟栈
     */
    public int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法入栈！");
            return;
        }

        stack[++top] = value;
    }

    /**
     * 入栈操作符，为了Calculator
     * @param value
     * @return 返回入栈结果
     *  当前操作符的优先级 <= 栈顶的操作符 时返回false
     *  当前操作符的优先级 > 栈顶的操作符 时返回true
     */
    public boolean pushOperator(int value) {
        // 如果栈为空直接入栈
        if (isEmpty()) {
            push(value);

            return true;
        }
        int priority  = getPriority(value);
        if (priority == -1) {
            throw new RuntimeException("操作符错误，传入操作符为：" + (char) value);
        }
        if (priority <= getPriority(peek())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈！");
        }

        return stack[top--];
    }

    /**
     * 查看栈顶的值
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 遍历栈，从top向栈底遍历
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无数据");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }

    /**
     * 转换操作符的优先级
     * @param value
     * @return
     */
    private int getPriority(int value) {
        char operator = (char) value;
        int priority = -1;
        switch (operator) {
            case '+':
            case '-':
                priority = 1;
               break;
            case '*':
            case '/':
                priority = 2;
                break;
            default:
                break;
        }

        return priority;
    }


}
