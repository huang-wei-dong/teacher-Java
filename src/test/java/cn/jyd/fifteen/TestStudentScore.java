package cn.jyd.fifteen;

import cn.jyd.StudentManagement.entity.Score;
import cn.jyd.five.Student;
import org.junit.Test;

import java.time.LocalDate;

public class TestStudentScore {
    /**
     * 测试学生成绩
     */
    @Test
    public void testStudentScore() {
        Student student = new Student("111", "张三", "男", LocalDate.of(2004, 1, 1), 90);
        ExCollection<Score> scores = student.getScores();
        student.showScores();
    }
}
