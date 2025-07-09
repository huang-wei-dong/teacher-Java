package cn.jyd.designPattern;

import cn.jyd.designPatterns.PrinterSingleton;
import org.junit.jupiter.api.Test;

/**
 * 单例模式测试类
 */
public class PrinterSingletonTest {
    @Test
    public void singletonTest() {
        PrinterSingleton printerSingleton1 = PrinterSingleton.getInstance();
        PrinterSingleton printerSingleton2 = PrinterSingleton.getInstance();
        // 输出 true，证明两个实例是同一个对象
        System.out.println(printerSingleton1 == printerSingleton2);
    }
}
