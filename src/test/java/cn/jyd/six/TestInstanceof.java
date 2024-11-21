package cn.jyd.six;

import cn.jyd.five.Student;
import cn.jyd.four.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestInstanceof {
    @Test
    public void testInstanceof()
    {
        Person p1 = new Person("1111","张三","男", LocalDate.of(1990,1,1));
        System.out.println("p1 instanceof Person:"+String.valueOf(p1 instanceof Person));
        Student s1 = new Student("2222","????","?", LocalDate.of(1990,1,1),90);
        System.out.println("s1 instanceof Student:"+String.valueOf(s1 instanceof Student));
        System.out.println("s1 instanceof Person:"+String.valueOf(s1 instanceof Person));
        System.out.println("p1 instanceof Student:"+String.valueOf(p1 instanceof Student));

    }
}
