package cn.jyd.Thirteen;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

/**
 * 测试Arrays、System、Console
 */
public class TestArraysSystemConsole {
    /**
     * 测试Arrays,Example 8_25
     */
    @Test
    public void testArrays(){
        Random randomOne = new Random(2022);
        //相同的随机数种子，产生相同的随机数序列
        Random randomTwo = new Random(2022);
        int amount=10000;
        int[] one = new int[amount];
        int[] two = new int[amount];
        for (int i = 0; i < amount; i++) {
            one[i] = randomOne.nextInt(amount);
            two[i] = randomTwo.nextInt(amount);
        }
        if(Arrays.equals(one,two)){
            System.out.println("两个数组相等，前8个元素分别是：");
            int[] a = Arrays.copyOfRange(one,0,8);
            int[] b = Arrays.copyOfRange(two,0,8);
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
        }else {
            System.out.println("两个数组不相等");
        }
        long start = System.nanoTime();
        Arrays.sort(one);
        Arrays.sort(two);
        long end = System.nanoTime();
        System.out.println("排序耗时(纳秒)："+(end-start)+"ns");
    }
}
