package cn.jyd.twelve;

/**
 * 多线程编程，第十二章 example12_1
 */
public class SpeakElephant extends Thread{
    public void run(){
        for(int i=1;i<=20;i++){
            System.out.print("大象"+i+" ");
        }
    }
}

class SpeakCar extends Thread{
    public void run(){
        for(int i=1;i<=20;i++){
            System.out.print("轿车"+i+" ");
        }
    }
}
