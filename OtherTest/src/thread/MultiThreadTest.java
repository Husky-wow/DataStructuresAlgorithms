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
    private int count = 1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        while (true) {
            synchronized (lock) {
                while (lock.getCount() != 1 && lock.getCount() != 6) {
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                lock.addCount();
                if (lock.getCount() == 7) {
                    lock.setCount(1);
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
        while (true) {
            synchronized (lock) {
                while (lock.getCount() != 2 && lock.getCount() != 5) {
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                lock.addCount();
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
        while (true) {
            synchronized (lock) {
                while (lock.getCount() != 3 && lock.getCount() != 4) {
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                lock.addCount();
            }
        }
    }
}
