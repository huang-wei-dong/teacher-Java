package cn.jyd.three;

import org.junit.Test;

public class Demo {
    @Test
    public void printPrefectNumber(){
        //从1-1000遍历
        for (int i = 1; i <1000 ; i++) {
            if(isPrefectNumber(i))
                System.out.println(i);
        }

        //如果是完数就打印
    }

    private boolean isPrefectNumber(int n) {
        //从1到n-1进行遍历
        //求出它的因子
        //求因子和
        //if因子和等于n，返回true
        int sum=0;
        for (int i = 1; i < n; i++) {
            if(n%i==0){
                sum+=i;
            }
        }
        return sum==n;
    }
}
