package cn.jyd.five;

/**
 * 设计模式之单例（单件）示例
 */
public class Printer {
    //静态变量，保存唯一实例
    private static Printer p1=null;
    //私有化构造函数，禁止外部直接访问
    private Printer(){}
    //向外部提供一个静态方法，返回唯一实例
    public static Printer getInstance(){
        if(p1==null){
            p1=new Printer();//类内部，可以访问private修饰的成员
        }
        return p1;
    }
}
