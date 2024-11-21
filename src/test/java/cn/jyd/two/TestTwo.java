package cn.jyd.two;

import org.junit.Test;

public class TestTwo {
    @Test
    public void testMax(){
        Two two = new Two();
        two.getMax();
    }
    @Test
    public void testGrade(){
        Two two = new Two();
        two.getGrade();
    }

    @Test
    public void testContinue(){
        Two two = new Two();
        two.getContinue();
    }
    @Test
    public void testBreak(){
        Two two = new Two();
        two.getBreak();
    }

    @Test
    public void testGradeBySwitch(){
        Two two = new Two();
        two.getGradeBySwitch();
    }
    @Test
    public void testOdd(){
        Two two = new Two();
        two.getOdd();
    }
    @Test
    public void testAbs(){
        Two two = new Two();
        two.getAbs();
    }

    @Test
    public void testFirst(){
        int a=1;
        int b=2;
        System.out.println("这是我第一个单元测试！");
        System.out.println("a+b="+(a+b));
    }

    //测试三元运算
    @org.junit.Test
    public void testSecondAbs(){
        int a=-9;
        int abs=a>=0?a:-a;
        System.out.println(a+"的绝对值是："+abs);
    }
}
