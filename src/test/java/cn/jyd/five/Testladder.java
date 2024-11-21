package cn.jyd.five;

import org.junit.Test;

public class Testladder {
    @Test
    public void testLadder(){
        Ladder ladder = new Ladder(1,2,3);
        System.out.println("梯形上底:"+ladder.getAbove());
        System.out.println("梯形下底:"+ladder.getBottom());
        System.out.println("梯形高:"+ladder.getHeight());
        System.out.println("梯形面积:"+ladder.computeArea());
        System.out.println("-------------------------------");
        ladder.setAbove(3);//设置梯形上底为3
        System.out.println("设置上底为3后");
        System.out.println("梯形上底:"+ladder.getAbove());
        System.out.println("梯形下底:"+ladder.getBottom());
        System.out.println("梯形高:"+ladder.getHeight());
        System.out.println("梯形面积:"+ladder.computeArea());
    }
}
