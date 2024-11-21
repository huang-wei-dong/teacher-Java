package cn.jyd.two;

import cn.jyd.Tools.ArrayTools;
import org.junit.Test;

public class TestMethod {
    // 可变参数测试
    @Test
    public void testVariableArguments(){
        int sum=Method.add(1,2,3,4);
        System.out.println(sum);
    }
    //测试参数简单传值调用
    //@Test
    public static void testSimpleArguments(){
        int a=1;
        int b=2;
        Method.swap(a,b);
        System.out.print("swap函数调用结束后：");
        System.out.println("a="+a+",b="+b);
    }
    //测试数组传值调用
    @Test
    public void testUpdateArray(){
        int[] a={1,2,3,4};
        System.out.println("updateArray函数调用前：");
        System.out.println("函数调用前a的地址："+a);
        ArrayTools.print(a);
        System.out.println("--------------------------------");
        Method.updateArray(a);
        System.out.println("--------------------------------");
        System.out.println("updateArray函数调用结束后：");
        System.out.println("函数调用后a的地址："+a);
        ArrayTools.print(a);
    }
}
