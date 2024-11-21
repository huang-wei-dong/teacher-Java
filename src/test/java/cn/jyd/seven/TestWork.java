package cn.jyd.seven;

import cn.jyd.five.Student;
import org.junit.Test;

public class TestWork {
    /**
     * 测试接口的多态工作
     * 多态：同样的接口，不同的实现，体现出不同的功能！
     */
    @Test
    public void testWork() {
        Work[] workers = new Work[]{new Teacher(),
                new SchoolMaster(), new Staff()};
        /**
         * 补充知识：这也实现一个观察者设计模式，
         * 观察者模式：一个事件，多个观察者，
         * 当事件发生时，通知观察者，观察者做出相应的处理！
         */
        for (Work worker : workers) {
            worker.planWork();
            worker.doWork();
            worker.workResult("工作圆满完成");
            System.out.println("----------------------");
        }
    }
    @Test
    public void testWork2() {
        Work worker=null ;
        System.out.println("-----学生工作情况--------");
        Student student = new Student();
        student.setName("张三");
        worker=student;
        worker.work();
        System.out.println("-----教师工作情况--------");
        cn.jyd.five.Teacher teacher=new cn.jyd.five.Teacher();
        teacher.setTeachingHours(100);
        teacher.setName("王明");
        worker=teacher;
        worker.work();
    }
}

