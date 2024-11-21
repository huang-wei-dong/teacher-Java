package cn.jyd.ten;

import org.junit.jupiter.api.Test;

/**
 * 异常
 */
public class TestException {
    /**
     * 数组越界异常
     */
    @Test
    public void testArrayIndexOutOfBoundsException()
    {
        try {
            int[] array = {1,2,3,4,5};
            //索引越界异常
            System.out.println(array[6]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 除数为0异常
     */
    @Test
    public void testArithmeticException()
    {
        try {
            int a = 1/0;
            //除数为0异常
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 空对象异常
     */
    @Test
    public void NullPointerException()
    {
        try {
            String str = "abc";
            //空对象异常
            System.out.println(str.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 类型转换异常
     */
    @Test
    public void testNumberFormatException()
    {
        try {
            String str ="98ba";
            //类型转换异常
            int a = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 断言
     */
    @Test
    public void testAssert()
    {
        int a = 2;
        int b = 2;
        assert a==b:"a和b不相等";//由于a和b不相等，断言失败，程序终止
        System.out.println("a和b相等");
    }
    //测试自定义异常
    @Test
    public void testMyException()
    {
        try {
            Bank bank = new Bank();
            bank.income(200,-100);
            bank.income(300,-100);
            bank.income(400,-100);
            System.out.printf("银行目前有:%d元\n",bank.getMoney());
            bank.income(200,100);
            bank.income(99999,-100);
        } catch (BankException e) {
            System.out.println("计算收益过程出现如下错误：");
            System.out.println(e.warnMess());
            e.printStackTrace();
        }
    }

    /**
     * 测试货轮超载异常
     * 特别是finally的执行
     */
    @Test
    public void testException6(){
        CargoBoat cargoBoat = new CargoBoat();
        cargoBoat.setMaxContent(1000);
        int m = 0;
        try {
            m=600;  cargoBoat.loading(m);
            m=300;  cargoBoat.loading(m);
            m=100;  cargoBoat.loading(m);
            m=555;  cargoBoat.loading(m);
        } catch (DangerException e) {
            System.out.println(e.warnMess());
            System.out.println("无法再装货"+m+"吨集装箱");
            try {
                cargoBoat.loading(-m);//卸货
            } catch (DangerException e1) {
                System.exit(0);
            }
        }finally {
            System.out.println("货船将正点启航");
            System.out.println("货轮目前有"+cargoBoat.realContent+"吨货物");
        }
    }
}
