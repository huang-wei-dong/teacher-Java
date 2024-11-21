package cn.jyd;

import cn.jyd.five.Student;
import cn.jyd.four.Person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 * 测试初始化数据
 */
public  class TestInit {
    //初始化person
    public static Person[] initPerson() {
        return new Person[]{
                new Person("111","张三","男",LocalDate.of(2002,2,4)),
                new Person("222","李四","女", LocalDate.of(2004,2,5)),
                new Person("333","王五","男",LocalDate.of(2000,1,1)),
                new Person("444","赵六","女",LocalDate.of(2005,5,5)),
                new Person("555","钱七","男",LocalDate.of(2001,1,3)),
                new Person("333","王五","男",LocalDate.of(2000,1,1))
        };
    }
    //初始化student
    public static Student[] initStudent() {
        return new Student[]{
                new Student("101","张三","男",LocalDate.of(2001,11,23),100),
                new Student("102","李四","男",LocalDate.of(2000,11,23),90),
                new Student("103","王五","女",LocalDate.of(2002,11,23),80),
                new Student("104","赵六","男",LocalDate.of(2002,12,2),70),
                new Student("105","孙七","女",LocalDate.of(2000,11,23),60),
                new Student("106","周八","男",LocalDate.of(1989,8,23),50),
                new Student("107","吴九","女",LocalDate.of(1990,6,23),40),
                new Student("108","郑十","男",LocalDate.of(1991,5,23),90),
        };
    }
    //打印时间
    public static void printTime(String msg) {
        System.out.println("---------------------------");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(msg + format.format(LocalDate.now()));
    }
    public static void printAuthor(){
        System.out.println("作者：教师 黄卫东");
        System.out.println("----------------------------");
    }
}
