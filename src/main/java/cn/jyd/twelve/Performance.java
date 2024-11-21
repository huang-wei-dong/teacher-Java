package cn.jyd.twelve;
/**
 * 进行多线程性能测试的
 */
public class Performance implements Runnable {
    private long count = 0;
    private static int lock = 0;
    public void setCount(long count) {
        this.count = count;
    }
    public synchronized static int getLock() {
        return lock;
    }


    @Override
    public void run() {
        plusLock();
        per();
        subLock();
    }

    public synchronized static void plusLock() {
        lock++;
    }
    public synchronized void subLock() {
        lock--;
    }

    private void per() {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a = i * 2;
        }
    }

}
