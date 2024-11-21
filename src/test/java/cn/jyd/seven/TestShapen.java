package cn.jyd.seven;

import org.junit.Test;

public class TestShapen {
    @Test
    public void testShapes()
    {
        Shapes shapes = new Square(5);
        shapes.printMessage();//调用正方形输出
        System.out.println("---------------------");
        shapes = new Circle(5);
        shapes.printMessage();//调用园的输出
        System.out.println("---------------------");
        shapes = new Rectangle(5,6);
        shapes.printMessage();//调用矩形的输出
    }
}
