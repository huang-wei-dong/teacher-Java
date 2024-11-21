package cn.jyd.fifteen;

import org.junit.Test;

import java.util.Stack;

public class TestStack {
    /**
     * 测试堆栈
     * Example 15_6
     * 本程序演示通过堆栈计算斐波那契数列
     * 斐波那契数列：1，1，2，3，5，8，13，21
     * 斐波那契数列的计算公式：f(n)=f(n-1)+f(n-2)
     */
    @Test
    public void testStack(){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);  System.out.println(1);
        stack.push(1);  System.out.println(1);

        for (int i = 3; i <=10 ; i++) {
            int f2=stack.pop();
            int f1=stack.pop();
            int f=f1+f2;
            System.out.println(f);
            stack.push(f2);
            stack.push(f);
        }
    }
}
