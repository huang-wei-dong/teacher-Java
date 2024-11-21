package cn.jyd.Thirteen;

import cn.jyd.thirteen.Roulette;
import org.junit.Test;

public class TestRoulette {
    /**
     * 测试抽奖
     */
    @Test
    public void testRoulette() {
        Roulette roulette = new Roulette();
        for (int i = 1; i <= 10000; i++) {
            System.out.print(roulette.draw()+" ");
            if(i%10==0){
                System.out.println();
            }
        }
        roulette.printResult();
    }
}
