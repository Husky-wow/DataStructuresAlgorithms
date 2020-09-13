package threadlcoal;

/**
 * @author admin
 * @ClassName ThreadLocalTestDemo.java
 * @Description TODO
 * @createTime 2020年09月13日 22:08:00
 */
public class ThreadLocalTestDemo {

    private ThreadLocal<String> tl = new ThreadLocal<>();

    /**
     * 变量
     */
    private String content;

    private String getContent() {
        // 普通方法
        // return content;

        // ThreadLocal方法，获取当前线程绑定的变量
        return tl.get();
    }

    private void setContent(String content) {
        // 普通方法
        // this.content = content;

        // ThreadLocal方法, 当前线程绑定content变量
        tl.set(content);


    }

    public static void main(String[] args) {

        ThreadLocalTestDemo demo = new ThreadLocalTestDemo();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /*
                    每个线程中先存变量，在取变量
                     */
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("--------------------------------");
                    System.out.println(Thread.currentThread().getName() + "------>" + demo.getContent());
                }
            });

            thread.setName("线程" + i);
            thread.start();
        }


    }




}
