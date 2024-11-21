package cn.jyd.fifteen;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TestTreeSet {
    /**
     * TreeSet测试
     * TreeSet默认情况下，按照元素的compareTo方法进行排序，
     * 如果compareTo方法返回0，则认为两个元素相等，则不会添加到TreeSet中。
     */
    @Test
    public void testTreeSet() {
        TreeSet<Student> treeSet = new TreeSet<>();
        for (Student student : TestInit.initStudent()) {
            treeSet.add(student);
        }
        treeSet.forEach(Student::show);
    }
}
