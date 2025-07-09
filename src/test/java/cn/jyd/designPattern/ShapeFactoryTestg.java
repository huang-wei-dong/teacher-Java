package cn.jyd.designPattern;

import cn.jyd.designPatterns.Factory.Shape;
import cn.jyd.designPatterns.Factory.ShapeFactory;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTestg {
    /**
     * 测试创建图形
     */
    @Test
    public void createShapeTest()
    {
        Shape circle = ShapeFactory.createShape("circle");
        Shape rectangle = ShapeFactory.createShape("rectangle");
        circle.draw();    // 输出：绘制圆形
        rectangle.draw(); // 输出：绘制矩形
    }
}
