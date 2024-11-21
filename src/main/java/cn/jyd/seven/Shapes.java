package cn.jyd.seven;

/**
 * 封闭图形接口
 */
public interface Shapes {
    final static double PI=3.14;//定义圆周率，接口中定义常量
    // 计算面积
    double area();
    // 计算周长
    double perimeter();
    /**
     * 打印信息
     * 默认实现，java 8后的新特性
     */
    default void printMessage(){
        System.out.println("图形面积："+area()+",图形周长："+perimeter());
    }
}
