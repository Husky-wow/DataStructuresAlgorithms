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


}
