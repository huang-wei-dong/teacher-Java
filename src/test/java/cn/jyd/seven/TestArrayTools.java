package cn.jyd.seven;

import cn.jyd.TestInit;
import cn.jyd.Tools.ArrayTools;
import cn.jyd.five.Student;
import org.junit.Test;

public class TestArrayTools {
    @Test
    public void testSortArray(){
        Student[] students = TestInit.initStudent();
        ArrayTools<Student> arrayTools = new ArrayTools<Student>(students);
        arrayTools.sort((Student s1, Student s2)->s2.getAge()-s1.getAge());
        arrayTools.print();
    }
}
