package cn.jyd.engineering;

import java.io.IOException;
import java.nio.ReadOnlyBufferException;

/**
 * 自定义日期类
 *用于演示软件工程的一些示例
 */
public class MyDate {
    private final int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        if(!isValid(year,month,day)){
            throw new RuntimeException("日期不合法");
        }
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    /**
     * 判断是否为闰年
     * @return True：为闰年，False：为平年
     */
    public boolean isLeapYear(int year ){
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }
    /**
     * 判断年，月，日的合法性
     */
    private boolean  isValid(int year,int month,int day){
        if(isLeapYear(year)){//闰年2月29天
            days[1]=29;
        }
        if(year<0){//年不能为负数
            return false;
        }
        if(month<1 || month>12){//月份不能小于1或者大于12
            return false;
        }
        if( day<1 || day>days[month-1] ){//天数不合法
            return false;
        }
        return true;
    }

    /**
     * 下一天
     * @return 下一天
     */
    public MyDate nextDay(){
        if(day<days[month-1]){//不是本月最后一天
            day++;
        }else{//是本月最后一天
            day=1;
            if(month<12){
                month++;
            }else{
                month=1;
                year++;
            }
        }
        return this;
    }

    /**
     * 重新定义toString方法
     * @return 日期字符串
     */
    public String toString(){
        return year+"-"+month+"-"+day;
    }
    /**
     * 重写equals方法
     * @param obj 其它日期对象
     * @return true：相等，false：不相等
     */
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof MyDate myDate){
            return this.year==myDate.year&&this.month==myDate.month&&this.day==myDate.day;
        }
        return false;
    }
}
