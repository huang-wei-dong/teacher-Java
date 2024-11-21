package cn.jyd.one;

import org.junit.Test;

public class TestPractice {
    @Test
    public void testEx02_05(){
        int[] a= {10,20,30,40},b[]={{1,2},{4,5,6,7}};
        b[0]=a;
        b[0][1]=b[1][3];
        System.out.println(b[0][3]);//40
        System.out.println(a[1]);//7
        for (int i : b[0]) {
            System.out.println(i);
        }
    }
    @Test
    public void testEx02_04(){
        Practice p=new Practice();
        p.ex01_04();
    }
}
