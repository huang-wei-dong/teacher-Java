/*第一次提交
 *作者：黄卫东
 * 时间：2024/9/1
 * 描述：控制台输入"Hello and welcome!"
 *   输出1到5的数字
 * */
package cn.jyd;

import cn.jyd.seven.Circle;
import cn.jyd.seven.ComputeShapes;
import cn.jyd.seven.Rectangle;

public class Main {
    public static void main(String[] args) {
        Circle c=new Circle(5);
        ComputeShapes cs=new ComputeShapes(c);
        cs.showAreaAndPerimeter();

        Rectangle r=new Rectangle(5,10);
        cs=new ComputeShapes(r);
        cs.showAreaAndPerimeter();


        long[] a={1,2,3,4};
        long[] b={100,200,300,400,500};
        b=a;
        System.out.println("数组b的长度："+b.length);
        System.out.println("b[0]="+b[0]);
    }
}