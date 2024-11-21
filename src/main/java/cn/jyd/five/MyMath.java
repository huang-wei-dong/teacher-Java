package cn.jyd.five;
//自定义 数学类
public class MyMath {
    static final float PI=3.14f;
    static final float E=2.718f;
    static float add(float a,float b){
        System.out.println("调用float add");
        return a+b;
    }
    static int add(int a,int b) {
        System.out.println("调用int add");
        return a + b;
    }
    static String add(String a,String b){
        System.out.println("String add");
        return a+b;
    }
}
