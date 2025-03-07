package cn.jyd.twelve;


import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class TestThreadMain {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        System.setOut(printStream);
        //testThread2();
        //example12_3();
        //example12_4();
        //example12_6();
        //example12_7();
        //example12_8();
        //example12_9();
        //example12_13();
        testThreadPerformance();//测多线程性能
    }

    /**
     * 测试线程，Example 12_2
     * 通过实现Runnable接口
     */
    private static void testThread2() {
        ElephantTarget elephantTarget = new ElephantTarget();
        CarTarget carTarget = new CarTarget();
        new Thread(elephantTarget).start();
        new Thread(carTarget).start();
        for (int i = 1; i <= 15; i++) {
            System.out.print("主线程" + i + " ");
        }
        System.out.println();
    }

    private static void example12_3() {
        House house = new House();
        house.setWaterAmount(10);
        Thread dog, cat;
        dog = new Thread(house);
        cat = new Thread(house);
        dog.setName("狗");
        cat.setName("猫");
        dog.start();
        cat.start();
    }

    private static void example12_4() {
        House2 house = new House2();
        house.setWaterAmount(10);
        house.dog.start();
        house.cat.start();
    }

    private static void example12_6() {
        ClassRoom room6501 = new ClassRoom();
        room6501.getStudent().start();
        room6501.getTeacher().start();
    }

    /**
     * 线程同步测试，模拟银行存钱和取钱，example12_7
     */
    private static void example12_7() {
        Bank bank = new Bank();
        bank.setMoney(200);
        Thread account = new Thread(bank);//会计
        account.setName("会计");
        Thread cashier = new Thread(bank);//出纳
        cashier.setName("出纳");
        account.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        cashier.start();
    }

    /**
     * 协调线程同步测试，模拟排队买票，example12_8
     * 前面的人由于无法找零等待后面的人买票，直到可以找零为止
     */
    private static void example12_8() {
        TicketHouse ticketHouse = new TicketHouse();
        Thread zhangfei = new Thread(ticketHouse);
        zhangfei.setName("张飞");
        Thread likui = new Thread(ticketHouse);
        likui.setName("李逵");
        zhangfei.start();
        likui.start();
    }

    /**
     * 线程联合，example12_9
     * 线程1和线程2，当线程1执行到join()的时候，线程2会等待线程1执行完毕，再继续执行
     */
    private static void example12_9() {
        ThreadJoin t1 = new ThreadJoin();
        Thread customer = new Thread(t1);
        customer.setName("顾客");
        Thread cakeMaker = new Thread(t1);
        cakeMaker.setName("蛋糕师");
        t1.setThread(customer, cakeMaker);
        customer.start();
    }

    /**
     * 守护线程，Example 12_13
     */
    private static void example12_13() {
        Daemon daemon = new Daemon();
        daemon.A.start();
        daemon.B.setDaemon(true);//设置B为守护线程
        daemon.B.start();
    }

    /**
     * 测试多线程性能
     */
    private static void testThreadPerformance() {
        long count = 1000000000L;//循环次数
        int threadCount = 1;//线程数

        Performance performance = new Performance();
        performance.setCount(count);
        Thread thread1 = new Thread(performance);
        long startTime = System.currentTimeMillis();
        try {
            thread1.start();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("1个线程," + count + "次循环操作，耗时：" + (endTime - startTime) + "ms");

        Thread thread=new Thread(new Runnable(){
            public void run(){
                Thread[] threads = new Thread[threadCount];

                for (int i = 0; i < threadCount; i++) {
                    Performance per = new Performance();
                    per.setCount(count / threadCount);
                    threads[i] = new Thread(per);
                }
                long startTime= System.currentTimeMillis();
                for (int i = 0; i < threadCount; i++) {
                    threads[i].start();
                }
                while (Performance.getLock().get()!=0){}
                long endTime= System.currentTimeMillis();
                System.out.println(threadCount + "个线程," + count + "次循环操作，耗时：" + (endTime - startTime) + "ms");
            }
        });
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

