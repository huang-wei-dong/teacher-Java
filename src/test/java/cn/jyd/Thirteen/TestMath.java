package cn.jyd.Thirteen;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

public class TestMath {
    /**
     * 产生100万个[0,99] 随机整数，统计每个数字产生的频数，
     * 计算每个数产生的频率，并输出偏差超过理论值2%的数。
     */
    @Test
    public void testFrequency(){
        int amount = 1000000;
        int[] frequency = new int[100];
        Random random = new Random(1);
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(100);
            frequency[index]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            double frequencyPercent = (double) frequency[i] / amount;
            // 每个数的理论概率为0.01
            double error= Math.abs(frequencyPercent-0.01);
            if(error>0.01*0.02 ){
                System.out.print(i+"的频率为:"+frequencyPercent);
                System.out.println(",其误差为："+error);
            }
        }
    }

    /**
     * 测试Random
     */
    @Test
    public void testRandom(){
        Random random = new Random(1);
        for (int i = 0; i < 10; i++) {
            // 产生[0,100)的整数
            System.out.println(random.nextInt(100));
        }
    }
    /**
     * 测试Math,Example 8_20
     */
    @Test
    public void testMath(){
        double a = 5.0;
        double st= Math.sqrt(a);
        System.out.println(a+"的平方根："+st);
        a=-a;
        st= Math.sqrt(a);
        System.out.println(a+"的平方根："+st);
        System.out.printf("大于等于%f的最小整数%d\n",5.2,(int)Math.ceil(5.2));
        System.out.printf("小于等于%f的最小整数%d\n",-5.2,(int)Math.floor(-5.2));
        System.out.printf("%f四舍五入的整数：%d\n",12.9,Math.round(12.9));
        System.out.printf("%f四舍五入的整数：%d\n",-12.6,Math.round(-12.6));
        BigInteger result = BigInteger.valueOf(0);
        BigInteger one =new BigInteger("123456789");
        BigInteger two =new BigInteger("987654321");
        result = one.add(two);
        System.out.println(one+" + "+two+"="+result);
        result = one.multiply(two);
        System.out.println(one+" * "+two+"="+result);
    }
}
