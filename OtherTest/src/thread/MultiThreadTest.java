package thread;

/**
 * @author xuxiaoding
 * @version 1.0.0
 * @ClassName MultiThreadTest.java
 * @Description 创建3个线程，分别不停地打印A、B、C 要求，打印结果必须是AABBCCAABBCCAABBCC
 */
public class MultiThreadTest {

    public static void main(String[] args) {
        CustomLock lock = new CustomLock();

        Thread threadA = new Thread(new RunnerTaskA(lock));
        threadA.start();

        Thread threadB = new Thread(new RunnerTaskB(lock));
        threadB.start();

        Thread threadC = new Thread(new RunnerTaskC(lock));
        threadC.start();
    }


}

class CustomLock {
    private int count = 3;

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}

class RunnerTaskA implements Runnable {

    private CustomLock lock;

    public RunnerTaskA(CustomLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
                for (int j = 0;  j < 2; j++) {
                    if (lock.getCount() % 3 == 0) {
                        lock.addCount();
                        for (int i = 0; i < 2; i++) {
                            System.out.println("A");
                        }
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}

class RunnerTaskB implements Runnable {

    private CustomLock lock;

    public RunnerTaskB(CustomLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("B");
                }
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RunnerTaskC implements Runnable {

    private CustomLock lock;

    public RunnerTaskC(CustomLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int j = 0; j < 2; j++){
                for (int i = 0; i < 2; i++) {
                    System.out.println("C");
                }
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
