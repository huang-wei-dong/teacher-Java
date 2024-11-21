package cn.jyd.twelve;

/**守护线程
 * Example 12_13.
 */
public class Daemon implements Runnable {
    Thread A,B;
    public Daemon() {
        A = new Thread(this);
        B = new Thread(this);
    }

    @Override
    public void run() {
        if(Thread.currentThread()==A){
            for (int i = 0; i < 10; i++) {
                System.out.println("i="+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
        }else if(Thread.currentThread()==B){
            while(true){
                System.out.println("B 是守护线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            }
        }
    }
}
