package cn.jyd.exam;

import cn.jyd.seven.Shapes;

import java.util.Map;

/**
 * 学校老师命题
 */
public class SchoolTeacher {
    public static void main(String[] args) {
        //选择3
//        float fooo = 42e1;
//        float foo=3.14;
//        float foo1 = 3.03d;
//        float foo2=0x0123;
        //选择4
//        char ch = "R";
//        char ch1 = '\\';//原题缺分号
//        char ch2 = 'ABCD';
//        char ch3 = "ABCD";

        //选择15,所有选择均无分号
//        int m = Float.parseFloat("567");
//        int m1 = Short.parseShort("567");
//        byte m2 = Integer.parseInt("2");
//        float m3 = Float.parseDouble("2.9");


        TE te = new TE();
        Dog dog2 = new Dog(5);
        Dog dog = new Dog(5.2);
        //Dog dog3 = new Dog();
    }
}
//判断正误第5题，5、构造方法的访问权限可以是public、protected、private或者友好的
class  TE  {
    protected TE(){
        System.out.println("protected");
    }
    private TE(String s){
        System.out.println("private");
    }
    public TE(double m){
        System.out.println("public");
    }
    TE(char c){
        System.out.println("default");
    }
}
//选择题第8题
class Dog {
    Dog(int m){
    }
    Dog(double  m){
    }
    int Dog(int m){
        return 23;
    }
    void Dog(double m){
    }
}
//选择题第11题,C.	如果一个非抽象类实现某个接口，那么它可以只重写接口中的部分方法
//正确，可以不重写default方法
class VV implements Shapes{
    @Override
    public double area() {
        return 0;
    }
    @Override
    public double perimeter() {
        return 0;
    }
}
//选择题第13题,A.	匿名类没有构造方法(正确)，
// 应该理解为匿名类调用父类的构造函数创建对象，而非定义了自己的构造函数
//对匿名类实现接口，可理解为匿名类调用了系统默认的构造函数，然后重写了接口方法




