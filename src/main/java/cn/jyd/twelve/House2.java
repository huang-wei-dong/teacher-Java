package cn.jyd.twelve;

/**
 * 线程同时访问同一资源
 * Example: 12_4
 */
public class House2 implements Runnable{
    int waterAmount = 0;
    public void setWaterAmount(int waterAmount){
        this.waterAmount = waterAmount;
    }
    public Thread dog;
    public Thread cat;
    public House2(){
        dog = new Thread(this, "狗");
        cat = new Thread(this, "猫");
    }
    @Override
    public void run() {
        while (true) {
            Thread thread = Thread.currentThread();
            String name = Thread.currentThread().getName();
            if (thread==dog) {
                System.out.println("狗在喝水");
                waterAmount -= 2;
            } else if (thread==cat) {
                System.out.println("猫在喝水");
                waterAmount -= 1;
            }
            System.out.println("当前水量：" + waterAmount);
            try {
                Thread.sleep(1000);//线程休眠时间
                System.out.println("休息");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (waterAmount <= 0) {
                System.out.println("水干，游戏结束");
                return;
            }
        }
    }
}
