package cn.jyd.thirteen;

import java.util.Arrays;
import java.util.Random;

/**
 * 轮盘赌
 * 模拟抽奖，随机产生一个数字，根据数字的范围决定抽奖的等级
 *三等奖70%，二等奖20%，一等奖9.9%，特等奖0.1%
 */
public class Roulette {
    private Random random;
    /**
     * 中奖的次数，count[3]:三等奖的次数,count[2]:二等奖的次数
     * ，count[1]:一等奖的次数，count[0]:特等奖的次数
     */
    private long[] count; //三等奖的概率
    public Roulette(){
        random=new Random();
        count=new long[4];
        System.out.println("欢迎来到抽奖系统");
    }
    /**
     * 模拟抽奖
     */
    public String draw(){
        int number=random.nextInt(1000);
        String result="";
        if(number>=300){
            count[3]++;
            result="3";
        }else if(number>=100){
            count[2]++;
            result="2";
        }else if(number>=1){
            count[1]++;
            result="1";
        }else{
            count[0]++;
            result="特";
        }
        return result;
    }
    /**
     * 统计中奖的次数和中将概率
     */
    public void printResult(){
        long total= Arrays.stream(count).sum();
        System.out.println("中奖的总次数为："+total);
        for(int i=3;i>=0;i--){
            System.out.printf("中奖的概率为：%4.2f%%, 中奖的次数为：%d\n"
                    ,((double)count[i]/total*100),count[i]);
        }
    }
}
