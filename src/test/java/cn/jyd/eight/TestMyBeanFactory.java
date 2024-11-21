package cn.jyd.eight;

import cn.jyd.eight.MyBeanFactory;
import cn.jyd.seven.Shapes;
import org.junit.Test;

public class TestMyBeanFactory {
    @Test
    public void testShapeBeanFactory()
    {
        MyBeanFactory factory =new MyBeanFactory();
        Shapes shapes = factory.getShapesBean("cn.jyd.seven.Square");
        shapes.printMessage();
        System.out.println("-----------------------------------");
        shapes= factory.getShapesBean("cn.jyd.seven.Circle");
        shapes.printMessage();
    }
}
