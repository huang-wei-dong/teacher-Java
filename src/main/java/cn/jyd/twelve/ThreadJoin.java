package cn.jyd.twelve;

/**
 * 线程联合，example12_9
 * 如果A线程调用了B线程的join()方法，则A线程会等待B线程执行完毕才继续往下执行。
 */
public class ThreadJoin implements Runnable {
    Cake cake;
    Thread customer;// 顾客
    Thread cakeMaker;// 蛋糕师
    public void setThread(Thread ...t){
        customer=t[0];
        cakeMaker=t[1];
    }

    @Override
    public void run() {
        if(Thread.currentThread()==customer){
            System.out.println(customer.getName()+"等待"
                    +cakeMaker.getName()+"生产蛋糕");
            try {
                cakeMaker.start();
                cakeMaker.join();// 等待蛋糕师生产蛋糕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(customer.getName()+"买到"+cake.name+"，花费"+cake.price);
        } else if (Thread.currentThread()==cakeMaker) {
            System.out.println(cakeMaker.getName()+"开始生产蛋糕,请等待");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cake=new Cake(120,"生日蛋糕");
            System.out.println(cakeMaker.getName()+"生产了"+cake.name+"，花费"+cake.price);
        }
    }
    /**
     * 内部类，蛋糕
     */
    class Cake {
        int price;
        String name;
        public Cake(int price, String name)
        {
            this.price = price;
            this.name = name;
        }
    }
}
