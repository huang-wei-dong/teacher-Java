package cn.jyd.four;

import org.junit.Test;

public class TestComplex {
    @Test
    public void testComplex() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex c3 = c1.add(c2);
        Complex c4 = c1.sub(c2);
        System.out.println(c3.toString());
        System.out.println(c4.toString());
    }

}
