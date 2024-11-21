package cn.jyd.five;

import cn.jyd.four.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * 测试继承
 */
public class TestExtends {
    @Test
    public void testExtends() {
        Person p = new Person("1", "张三", "男", LocalDate.of(1999, 1, 1));
        p.showMessage();
        Student s = new Student("11", "学生", "男", LocalDate.of(2001, 1, 1), 100);
        s.showWithScore();
        Teacher t = new Teacher("21", "老师", "男", LocalDate.of(1999, 2, 2), 100);
        t.showMessage();
    }
}
