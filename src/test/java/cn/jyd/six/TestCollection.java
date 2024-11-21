package cn.jyd.six;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import cn.jyd.TestInit;
import cn.jyd.five.Student;
import cn.jyd.four.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Iterator;

public class TestCollection {
    @Test
    public void testCollection(){
        System.out.println("-----基础集合------");
        BaseCollection<Integer> bc =
                new BaseCollection<Integer>(10);
        bc.add(3);
        bc.add(6);
        bc.add(2);
        bc.add(7);
        bc.add(6);
        bc.add(1);
        bc.show();
        System.out.println("-----元素不重复集合------");
        UniqueCollection<Integer> un =
                new UniqueCollection<Integer>(10);
        un.add(3);
        un.add(6);
        un.add(2);
        un.add(7);
        un.add(6);
        un.add(1);
        un.show();
    }

    @Test
    public void testBaseCollectionForString(){
        BaseCollection<String> oc =
                new BaseCollection<String>(10);
        oc.add("苹果");
        oc.add("桔子");
        oc.add("香蕉");
        oc.add("banana");
        oc.show();
    }
    @Test
    public void testBaseCollectionForPerson(){
        BaseCollection<Person> oc =
                new BaseCollection<Person>(10);
        oc.add(new Person("20170101","张山","男",LocalDate.of(2001,11,23)));
        oc.add(new Person("20170102","李四","女",LocalDate.of(2002,12,24)));
        oc.add(new Person("20170103","王五","男",LocalDate.of(2003,1,25)));
        oc.add(new Person("20170104","赵六","女",LocalDate.of(2004,2,26)));
        oc.show();
    }
    @Test
    public void testBaseCollectionForArray(){
        BaseCollection<Person> oc =new BaseCollection<>(TestInit.initPerson());
        oc.show();
        System.out.println("------删除元素后-------");
        Person p = new Person("333","王五3","男",LocalDate.of(2000,1,1));
        oc.remove(p);
        oc.show();
    }

    //有序集合
    @Test
    public void testOrderCollection(){
        System.out.println("-----有序集合------");
        BaseCollection<Integer> oc =new UniqueCollection<>(10);
        oc.add(3);
        oc.add(6);
        oc.add(2);
        oc.add(7);
        oc.add(6);
        oc.add(1);
        oc.show();
        System.out.println("-----学生成绩有序集合------");
        OrderlyCollection<Student> sc =new OrderlyCollection<Student>(10);
        sc.add(new Student("20170101","张三","男",LocalDate.of(2001,11,23),90));
        sc.add(new Student("20170102","李四","女",LocalDate.of(2002,12,24),80));
        sc.add(new Student("20170103","王五","男",LocalDate.of(2003,1,25),70));
        sc.add(new Student("20170104","赵六","女",LocalDate.of(2004,2,26),75));
        sc.show();
    }

    /**
     * 集合多态测试
     * 相同的客户端调用，但实现不同，体现为多态
     */
    @Test
    public void testCollection3(){
        polymorphism(new BaseCollection<Integer>(10),"---基础集合---");
        polymorphism(new UniqueCollection<Integer>(10),"---元素不重复集合---");
        polymorphism(new OrderlyCollection<Integer>(10),"---有序集合---");
    }
    private void polymorphism(BaseCollection<Integer> bc,String message ){
        System.out.println(message);
        bc.add(3);
        bc.add(6);
        bc.add(2);
        bc.add(7);
        bc.add(6);
        bc.add(1);
        bc.show();
    }
    //测试接口的迭代器
    @Test
    public void testIterator(){
        BaseCollection<Person> oc =new BaseCollection<>(TestInit.initPerson());
        oc.show();
        System.out.println("-----迭代器遍历------");
        oc.forEach(System.out::println);
        System.out.println(oc);
    }


}
