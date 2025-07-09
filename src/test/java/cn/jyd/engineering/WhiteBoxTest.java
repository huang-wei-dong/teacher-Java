package cn.jyd.engineering;

import org.junit.jupiter.api.Test;

public class WhiteBoxTest {

    public void fun(int x,int y, int z) {
        if(x>0 || y>0){
            System.out.println("output1");
        }
        if(x>1  || z>1){
            System.out.println("output2");
        }
    }
}
