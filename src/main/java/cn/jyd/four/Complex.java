package cn.jyd.four;
//复数类
public class Complex {
    // 成员变量，也称为属性
    private double real;
    private double imag;

    // 构造方法
    public Complex() {
        this.real = 0;
        this.imag = 0;
    }
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    //add方法
    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }
    //减法
    public Complex subtraction(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    // 获取实部
    public double getReal() {
        return real;
    }
    //设置实部
    public void setReal(double real) {
        this.real = real;
    }
    // 获取虚部
    public double getImag() {
        return imag;
    }
    //设置虚部
    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "复数类Complex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }
}

