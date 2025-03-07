package cn.jyd.seven;
/**
 * 园
 */
public class Circle implements Shapes {
    private double radius;//半径
    @Override
    public double area() {
        return PI*radius*radius;
    }
    @Override
    public double perimeter() {
        return 2*PI*radius;
    }
    public Circle(double radius)
    {
        this.radius=radius;
    }

    @Override
    public void printMessage()
    {
        System.out.println("这是一个园"+this.getClass().getName());
        System.out.println("园的半径为："+radius);
        Shapes.super.printMessage();
    }
}
