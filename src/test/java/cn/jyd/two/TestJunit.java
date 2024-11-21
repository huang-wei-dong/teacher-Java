package cn.jyd.two;

import cn.jyd.TestInit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 对junit框架进行实验
 * @author 黄卫东
 * @date 2018年6月26日
 * @version 1.0
 */
public class TestJunit {
    @Before//测试方法执行前执行
    public void init(){
        TestInit.printAuthor();
    }
    @After//测试方法执行后执行
    public void destroy(){
        TestInit.printTime("执行时间：");
    }
    @Test//测试方法
    public void testHello(){
        System.out.println("1+2="+(1+2));
    }

    /**
     * 计算两个数之和，
     * 用于演示javadoc注释风格的文档生成
     * @author 黄卫东
     * @param a 整数1
     * @param b 整数2
     * @return a+b的值
     */
    public int add(int a,int b){
        return a+b;
    }
}
