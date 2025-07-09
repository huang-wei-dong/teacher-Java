package cn.jyd.designPatterns;

/**
 * 单例模式
 */
public class PrinterSingleton {
    // 创建一个静态变量
    private static final PrinterSingleton instance=null;
    // 私有构造函数
    private PrinterSingleton() {
        System.out.println("PrinterSingleton被创建了");
    }
    // 单例的公共方法
    public static PrinterSingleton getInstance() {
        if(instance==null){// 判断实例是否已经创建
             new PrinterSingleton();
        }
        return instance;
    }
}
