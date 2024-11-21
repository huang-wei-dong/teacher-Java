package cn.jyd.seven;

/**
 * 二元运算接口
 */
public interface Operator {
    //一个抽象的二元运算，具体运算需由子类实现
    int operator(int a,int b);
}
