package cn.jyd.eight;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import cn.jyd.six.Boy;
import cn.jyd.six.GirlFriend;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAnonymous {
    /**
     * 匿名类
     */
    @Test
    public void testAnonymousClass() {
        Boy boy = new Boy();
        // 这里是一个匿名类
        GirlFriend girl = new GirlFriend() {
            @Override
            public void speak() {
                System.out.println("匿名朋友");
            }
            @Override
            public void cooking() {
                System.out.println("匿名朋友正在做菜");
            }
        };
        boy.setGirlFriend(girl);
        boy.showFriend();
    }


    @Test
    public void testAnonymousClass2() {
        ArrayList<Student> students = new ArrayList<>(
                List.of(TestInit.initStudent()));
        students.sort((s1,s2)->s1.getScore()- s2.getScore());
        students.forEach(Student::showWithScore);
    }
}
