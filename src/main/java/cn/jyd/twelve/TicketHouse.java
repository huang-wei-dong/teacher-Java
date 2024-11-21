package cn.jyd.twelve;

/**
 * 模拟卖票找零的情况
 * 排在前面的的由于不能找零，只能等待后面的人买票后，有找零时才能买票
 */
public class TicketHouse implements Runnable {
    int fiveAmount = 2;//5元的零钱2张
    int tenAmount = 0;//10元的零钱0张
    int twentyAmount = 0;//20元的零钱0张

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("张飞")) {
            saleTicket(20);//张飞用20元买票
        } else if (Thread.currentThread().getName().equals("李逵")) {
            saleTicket(5);//李逵用5元买票
        }
    }

    private synchronized void saleTicket(int money) {
        if (money == 5) {//每张票5元
            fiveAmount++;
            System.out.println(Thread.currentThread().getName() + "的钱正好，给他票");
        } else if (money == 20) {
            while (fiveAmount < 3) {//20元需要找零15元，3张5元
                try {
                    System.out.println(Thread.currentThread().getName() + "不够找零，等待");
                    wait();
                    System.out.println(Thread.currentThread().getName() + "继续买票");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fiveAmount -= 3;
            twentyAmount += 1;
            System.out.println(Thread.currentThread().getName() + "钱够，给他票,给20元找零15元");
        }
        notifyAll();//唤醒等待的线程
    }
}
