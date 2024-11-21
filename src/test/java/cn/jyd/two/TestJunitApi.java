package cn.jyd.two;

import org.junit.Assert;

public class TestJunitApi {
    @org.junit.jupiter.api.Test
    public void testSecondAbs(){
        int a=-9;
        int abs=a>=0?a:-a;
        System.out.println(a+"的绝对值是："+abs);
    }

    /**
     * 求绝对值
     * @param a 待求绝对值的数
     * @return a的绝对值
     */
    public int abs(int a){
        return a>=0?a:-a;
    }

    /**
     * 演示标准单元测试方法
     * 对abs函数进行自动化测试
     */
    @org.junit.jupiter.api.Test
    public void testAbs(){
        int result=abs(-9);//调用abs函数得到实践结果
        int expect=9;//期望值
        //断言：期望值与实际结果是否相等，相等则测试通过，否则不通过
        org.junit.jupiter.api.Assertions.assertEquals(expect,result);
    }
}
