package cn.jyd.seven;

import cn.jyd.TestInit;
import cn.jyd.Tools.ArrayTools;
import cn.jyd.five.Student;
import org.junit.Test;

public class TestLambda {

    private void towOpera(int a, int b, Operator operator){
        Number result= operator.operator(a, b);
        System.out.println(result);
    }
    @Test
    public void testLambda()
    {
        int a = 2;
        int b = 3;
        towOpera(a,b,(x, y)->x*y);
    }

    /**
     * 测试通过lambad表达式进行筛选
     */
    @Test
    public void testSelect()
    {
        Student[] array = TestInit.initStudent();
        ArrayTools<Student> students = new ArrayTools<>(array);
        students.select(s->s.getScore()>60);
    }
    /**
     * 测试通过lambad表达式进行排序
     */
    @Test
    public void testSort()
    {
        Student[] array = TestInit.initStudent();
        ArrayTools<Student> students = new ArrayTools<>(array);
        students.sort((s1,s2)->s1.getAge()-s2.getAge());
        students.println();
    }
}
