package cn.jyd.exam;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * 主类
 */
public class Test {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.setPower(135);
        Gearbox gearbox = new Gearbox();
        gearbox.setAmount(6);
        Car jeep = new Car();
        jeep.setEngine(engine);
        jeep.setGearbox(gearbox);
        jeep.show();
    }
}
class CPU{
    private int speed;
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
}
class HardDisk{
    private int amount;
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
}
class PC{
    private CPU cpu;
    private HardDisk hardDisk;
    public void setCpu(CPU cpu){
        this.cpu = cpu;
    }
    public void setHardDisk(HardDisk hardDisk){
        this.hardDisk = hardDisk;
    }
    public void show(){
        System.out.println("CPU的速度为："+cpu.getSpeed());
        System.out.println("硬盘容量为："+hardDisk.getAmount());
    }
}
