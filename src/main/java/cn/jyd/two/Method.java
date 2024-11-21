package cn.jyd.two;
import cn.jyd.Tools.ArrayTools;

public class Method {
    /**
     * 可变参数用法
     * @param x：可变参数代表
     * @return ：返回所有参数和
     */
    public static int add(int ...x){
        int sum = 0;
        for(int i=0;i<x.length;i++){//可变参数可以向数组一样使用
            sum+=x[i];
        }
        return sum;
    }
    /**
     * 参数传值示例
     * 简单数据类型交换两个变量的值
     * @param a：
     * @param b：
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.print("swap函数内：");
        System.out.println("a=" + a + ",b=" + b);
    }

    // 引用类型传值
    public static void updateArray(int[] a){
        System.out.println("函数内a的地址："+a);
        int [] b =new int[] {5,4,3,2,1};
        a=b;
        System.out.println("函数内数组a=b后，a的地址："+a);
        ArrayTools.print(a);
    }
}
