package cn.jyd.seven;

/**
 * 矩形
 */
public class Rectangle implements Shapes{
    private double side;
    private double width;
    @Override
    public double area() {
        return side*width;
    }
    @Override
    public double perimeter() {
        return side*2+width*2;
    }
    public Rectangle(double side,double width)
    {
        this.side=side;
        this.width=width;
    }
}
