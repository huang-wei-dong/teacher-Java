package cn.jyd.Thirteen;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestDateTime {
    /**
     * 测试日期类 Example 8_16
     */
    @Test
    public void testDate(){
        LocalDate dateOne = LocalDate.now();//本地当前日期
        System.out.println("本地日期："+dateOne);
        LocalDate dateTwo = LocalDate.of(2025, 1, 22);//自定义日期
        System.out.println("自定义日期："+dateTwo);
        System.out.println(dateOne+"在"+dateTwo+"之后："+dateOne.isAfter(dateTwo));
        System.out.println(dateOne+"在"+dateTwo+"之前："+dateOne.isBefore(dateTwo));
        System.out.println(dateOne+"和"+dateTwo+"相同："+dateOne.isEqual(dateTwo));
        int year=18;
        int month=23;
        int day=8976;
        LocalDate dateAgo= dateOne.plusYears(-year);//加上-year年
        System.out.println(dateOne+" "+year+"年前是：\n"+dateAgo);
        System.out.println("那天是"+dateAgo.getDayOfWeek());//星期几
        LocalDate dateAfter= dateTwo.plusYears(year).plusMonths(month).plusDays(day);
        System.out.println(dateTwo+"再过"+year+"年"+month+"月"+day+"天后是："+dateAfter);
        System.out.println("那天是"+dateAfter.getDayOfWeek());

        int second=1879;
        LocalTime time= LocalTime.of(23, 30, 1);//自定义时间
        LocalTime nextTime= time.plusSeconds(second);//加上second秒
        System.out.println(time+"再过"+second+"秒是："+nextTime);
    }
}
