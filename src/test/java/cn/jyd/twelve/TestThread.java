package cn.jyd.twelve;

import org.junit.Test;

/**
 * 测试线程，第十二章
 * @author jyd
 *
 */
public class TestThread {
    public TestThread(){}
    /**
     * 测试线程，Example 12_1
     */
    @Test
    public void testThread(){
        SpeakElephant elephant  = new SpeakElephant();
        SpeakCar car = new SpeakCar();
        elephant.start();
        car.start();
        for (int i = 1; i <=15 ; i++) {
            System.out.print("主线程"+i+" ");
        }
    }
    /**
     * 测试线程，Example 12_2
     * 通过实现Runnable接口
     */
    @Test
    public void testThread2(){
        ElephantTarget elephantTarget = new ElephantTarget();
        CarTarget carTarget = new CarTarget();
        new Thread(elephantTarget).start();
        new Thread(carTarget).start();
        for (int i = 1; i <=15 ; i++) {
            System.out.print("主线程"+i+" ");
        }
        System.out.println();
    }
    /**
     * 线程共享同一资源，Example 12_3
     */
    @Test
    public void testThread3(){
        House house = new House();
        house.setWaterAmount(10);
        Thread dog,cat;
        dog = new Thread(house);
        cat = new Thread(house);
        dog.setName("狗");
        cat.setName("猫");
        dog.start();
        cat.start();
    }
    /**
     * 线程共享同一资源，Example 12_4
     */
    @Test
    public void testThread4(){
        House2 house = new House2();
        house.setWaterAmount(10);
        house.dog.start();
        house.cat.start();
    }
    /**
     * 线程interrupt方法，Example 12_6
     */
    @Test
    public void testThread5(){
        ClassRoom room6501=new ClassRoom();
        room6501.getStudent().start();
        room6501.getTeacher().start();
    }

}
