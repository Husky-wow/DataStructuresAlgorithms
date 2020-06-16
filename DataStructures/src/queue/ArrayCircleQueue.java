package queue;

import java.util.Scanner;

/**
 * @author admin
 * @ClassName ArrayCircleQueue.java
 * @Description 数组环形队列
 * @createTime 2020年06月16日 22:43:00
 */
public class ArrayCircleQueue {
    /**
     * 初始化数组
     */
    int[] arrayQueue;
    int maxSize;
    /**
     * 头索引，第一个元素所在位置
     */
    int front = 0;
    /**
     * 尾索引，最后一个元素后一个位置（当队列满时，数组中有个位置没有数据）
     */
    int rear = 0;

    public ArrayCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arrayQueue = new int[maxSize];
    }

    public static void main(String[] args) {
        ArrayCircleQueue queue = new ArrayCircleQueue(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("l(ls) 显示数组");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列取出数据");
            System.out.println("h(head) 查看队列头部数据");
            key = scanner.next().charAt(0);

            try {
                switch (key) {
                    case 's':
                        queue.showQueue();
                        break;
                    case 'l':
                        queue.showArray();
                        break;
                    case 'e':
                        loop = false;
                        break;
                    case 'a':
                        System.out.print("输入一个数用于添加：");
                        int value = scanner.nextInt();
                        queue.addElement(value);
                        break;
                    case 'g':
                        System.out.println(queue.getElement());
                        break;
                    case 'h':
                        System.out.println(queue.showHead());
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }



    }

    /**
     * 判断队列是否已经存满
     * @return
     */
    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
    }


    private void addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        }

        arrayQueue[rear] = element;
        // 注意考虑对maxSize取余
        rear = (rear +1) % maxSize;
    }

    /**
     * 获取队列中的元素
     * @return
     */
    private int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }

        int value = arrayQueue[front];
        front = (front + 1) % maxSize;

        return value;
    }

    /**
     * 显示队列头部元素
     * @return
     */
    private int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法输出第一个元素");
        }

        return arrayQueue[front];
    }

    /**
     * 显示数组，从数组下标为0顺序显示
     */
    private void showArray() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无内容可以显示");
        }

        for (int i = 0; i < arrayQueue.length; i++) {
            System.out.printf("queue[%d] = %d\n", i, arrayQueue[i]);
        }
    }

    /**
     * 显示队列，从front顺序显示
     */
    private void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无内容可以显示");
        }

        for (int i = front; i < front + queueSize(); i++) {
            System.out.printf("queue[%d] = %d\n", i % maxSize, arrayQueue[i % maxSize]);
        }
    }

    /**
     * 计算队列中元素个数
     * @return
     */
    private int queueSize() {
        return (rear - front + maxSize) % maxSize;

    }



}
