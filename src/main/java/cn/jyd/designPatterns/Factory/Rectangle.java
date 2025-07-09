package cn.jyd.designPatterns.Factory;
/**
 * 矩形类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
