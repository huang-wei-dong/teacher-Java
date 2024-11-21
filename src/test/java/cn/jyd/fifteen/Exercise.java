package cn.jyd.fifteen;

import org.junit.Test;

import java.util.Stack;

public class Exercise {
    /**
     * 使用堆栈输出an的若干项，其中an=2*an-1+2*an-2,其中a1=3，a2=8
     */
    @Test
    public void Exercise1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(8);
        int n = 10;
        for (int i = 2; i < n; i++) {
            int a1=stack.pop();
            int a2=stack.pop();
            stack.push(a2);
            stack.push(a1);
            stack.push(2*a1+2*a2);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
