package cn.jyd.engineering;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

/**
 * 日期测试类
 */
public class MyDateTest {
    @Test
    public void testNextDay(){
        MyDate myDate=new MyDate(2020,1,1);
        System.out.println(myDate.nextDay());
    }
    /**
     * 采用断言进行测试
     * */
    @Test
    public void testNextDayAssertions(){
        MyDate myDate=new MyDate(2020,1,1);
        //断言
        Assertions.assertEquals(new MyDate(2020,1,2),myDate.nextDay());
    }
    /**
     * 有效等价类测试
     * */
    @Test
    public void testNextDay2() {
        // 输入日期
        List<MyDate> inputDates = List.of(
                new MyDate(2003, 3, 15)
                , new MyDate(2004, 2, 13)
                , new MyDate(1999, 2, 3)
                , new MyDate(1970, 9, 29));
        //  期望结果
        List<MyDate> expectDates = List.of(
                new MyDate(2003, 3, 16)
                , new MyDate(2004, 2, 14)
                , new MyDate(1999, 2, 4)
                , new MyDate(1970, 9, 30));
        //  执行测试
        for (int i = 0; i < inputDates.size(); i++) {
            System.out.print("input:"+inputDates.get(i));
            System.out.println("   expect:"+expectDates.get(i));
            Assertions.assertEquals(expectDates.get(i), inputDates.get(i).nextDay());
        }
    }
    /**
     * 边界值测试
     * */
    @Test
    public void testNextDay3() {
        // 输入日期
        List<MyDate> inputDates = List.of(
                new MyDate(2004, 2, 27)
                , new MyDate(2004, 2, 29)
                , new MyDate(2003, 2, 27)
                , new MyDate(2004, 3, 31)
                , new MyDate(2004, 4, 30)
                , new MyDate(2003, 12, 31));
        //  期望结果
        List<MyDate> expectDates = List.of(
                new MyDate(2004, 2, 28)
                , new MyDate(2004, 3, 1)
                , new MyDate(2003, 2, 28)
                , new MyDate(2004, 4, 1)
                , new MyDate(2004, 5, 1)
                , new MyDate(2004, 1, 1));
        //  执行测试
        for (int i = 0; i < inputDates.size(); i++) {
            System.out.print("input:"+inputDates.get(i));
            System.out.println("   expect:"+expectDates.get(i));
            Assertions.assertEquals(expectDates.get(i), inputDates.get(i).nextDay());
        }
    }
    /**
     * 无效等价类测试用例
     * */
    @Test
    public void testNextDay4() {
        int[][] inputDates = {{-1, 3, 20}, {2005, 0, 10}, {2009, 14, 25}, {1989, 2, -1}
                , {1977, 2, 30},{2000, 2, -2},  {2008, 2, 34}, {1956, 10, 0}, {1974, 8, 78}
                ,  {2007, 9, -3}, {1866, 4, 35}};
        for (int i = 0; i < inputDates.length; i++) {
            int finalI = i;
            Assertions.assertThrows(RuntimeException.class, () -> {
                new MyDate(inputDates[finalI][0], inputDates[finalI][1], inputDates[finalI][2]);
            });
        }
    }

    /**
     * 参数化测试，通过CSV文件读取参数作为测试数据
     * */
    @ParameterizedTest// 参数化测试
    //CSV文件作为参数来源，跳过第1行，从第2行开始读取参数
    @CsvFileSource(resources = "/testMyDate.csv", numLinesToSkip = 1)
    public void testNextDay5(ArgumentsAccessor arguments) {
        MyDate inputDate = new MyDate(arguments.getInteger(0),
                arguments.getInteger(1),
                arguments.getInteger(2));
        MyDate  expectedDate = new MyDate(arguments.getInteger(3),
                arguments.getInteger(4),
                arguments.getInteger(5));
        Assertions.assertEquals(expectedDate, inputDate.nextDay());
    }

    /**
     * 测试同一相同的实例, 测试equas方法重写
     */
    @Test
    public void myDateTest5() {
        MyDate myDate = new MyDate(2020, 1, 1);
        Assertions.assertEquals(myDate, myDate);
    }
    /**
     * 测试不同实例, 测试equas方法重写
     */
    @Test
    public void myDateTest6() {
        MyDate myDate = new MyDate(2020, 1, 1);
        MyDate myDate2 = new MyDate(2020, 1, 1);
        Assertions.assertEquals(myDate, myDate2);
    }

    /**
     * 测试不同对象, 测试equas方法重写
     */
    @Test
    public void myDateTest7() {
        MyDate myDate = new MyDate(2020, 1, 1);
        Assertions.assertNotEquals(myDate, "2020-01-01");
    }

    /**
     * 测试get方法
     */
    @Test
    public void getTest() {
        MyDate myDate = new MyDate(2020, 1, 1);
        Assertions.assertEquals(2020, myDate.getYear());
        Assertions.assertEquals(1, myDate.getMonth());
        Assertions.assertEquals(1, myDate.getDay());
    }
}
