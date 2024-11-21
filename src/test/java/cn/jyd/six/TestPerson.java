package cn.jyd.six;

import cn.jyd.five.Student;
import cn.jyd.four.Person;
import org.junit.Test;
import java.time.LocalDate;

public class TestPerson {
    // 测试People类的继承
    @Test
    public void testPerson(){
        Person p=new Person("20170101","张三","男",LocalDate.of(2001,11,23));
        p.showMessage();
        System.out.println("-------------------------------------");
        Student s=new Student("20170101","张三","男", LocalDate.of(2001,11,23),100);
        s.showWithScore();
    }
}
