package cn.jyd.four;

import org.junit.Test;

import java.time.LocalDate;

public class TestPerson {
    @Test
    public void testPerson()
    {
        //调用构造函数， 创建对象
        Person person1 = new Person("11111","张三","男",LocalDate.of(2002,8,1));
        //调用成员方法，获取姓名
        System.out.println(person1.getName());
        person1.setName("zhangshan");
        //调用成员方法，获取对象信息
        System.out.println(person1.toString());

        Person person2= new Person("22222","李四","女",LocalDate.of(2024,10,7));
        System.out.println(person2.toString());

        System.out.println("人口总数为："+Person.getCount());
    }
    //通过成员方法获取设置类的成员变量值
    @Test
    public void testPerson2() {
        Person p1 = new Person("33333","王五","男",LocalDate.of(2023,9,1));
        System.out.println(p1.toString());

        p1.setBirthday(LocalDate.of(1980,9,1));
        p1.setSex("女");
        System.out.println(p1.toString());
        System.out.println("年龄："+p1.getAge());
    }
    //测试内部类
    @Test
    public void testPerson3() {
        Person p1 = new Person("44444","赵六","男",LocalDate.of(2023,9,1));
        Person.Address address = p1.new Address("北京","朝阳区","西单");
        p1.showMessage();
        System.out.println(address.toString());
    }
    //测试静态成员变量和静态方法
    @Test
    public void testPerson4() {
        Person p1 = new Person("55555","钱七","男",LocalDate.of(2023,9,1));
        Person p2 = new Person("66666","孙八","男",LocalDate.of(2023,9,1));
        System.out.println("人口总数为："+Person.getCount());
        Person p3 = new Person();
        p3.setName("周九");
        System.out.println("加入p3后人口总数为："+Person.getCount());
    }
}
