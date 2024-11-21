package cn.jyd.twelve;
/**
 * 通过实现Runnable接口，实现多线程
 * Example 12_2
 */
public class ElephantTarget implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=20 ; i++) {
            System.out.print("大象"+i+" ");
        }
    }
}

class CarTarget implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=20 ; i++) {
            System.out.print("汽车"+i+" ");
        }
    }
}
