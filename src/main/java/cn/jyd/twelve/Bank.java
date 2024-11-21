package cn.jyd.twelve;

/**
 * 线程同步，example12_7
 * 模拟银行存钱和取钱的情况
 */
public class Bank implements Runnable{
    int money=200;
    public void setMoney(int money) {
        this.money = money;
    }
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("会计")){
            saveOrTake(300);
        } else if (Thread.currentThread().getName().equals("出纳")) {
            saveOrTake(150);
        }
    }

    /**
     * synchronized关键字，锁对象为this
     * 如其它线程要访问使用saveOrTake方法就必须等等，直到此线程完成该方法
     */

    private synchronized void saveOrTake(int amount) {
        if(Thread.currentThread().getName().equals("会计")){
            for (int i = 1; i <=3 ; i++) {
                money += amount/3;
                System.out.println(Thread.currentThread().getName()
                        +"存了"+amount/3+"元，余额为："+money+"休息一会再存");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Thread.currentThread().getName().equals("出纳")) {
            for (int i = 1; i <=3 ; i++) {
                int amountMoney=0;
                if(money>=500){
                    amountMoney=amount/2;
                } else if (money>=400&&money<500) {
                    amountMoney=amount/3;
                } else if (money>=200&&money<400) {
                    amountMoney=amount/5;
                } else if (money<200) {
                    amountMoney=amount/10;
                }
                money -= Math.min(amountMoney, money);
                System.out.println(Thread.currentThread().getName()
                        +"取了"+amountMoney+"元，余额为："+money+"休息一会再取");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
