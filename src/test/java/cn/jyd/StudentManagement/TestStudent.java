package cn.jyd.StudentManagement;

import cn.jyd.StudentManagement.mapper.StudentMapper;
import cn.jyd.fifteen.ExCollection;
import cn.jyd.five.Student;
import org.junit.Test;

import java.time.LocalDate;

public class TestStudent {
    private StudentMapper studentMapper=new StudentMapper();
    @Test
    public void testGetAllStudentStudent()
    {
        ExCollection<Student> allStudent =studentMapper.getAllStudent();
        allStudent.forEach(Student::fillScore);
        allStudent.forEach(Student::showWithScore);
    }

    /**
     * 依据学号查询学生
     */
    @Test
    public void testGetStudent()
    {
        Student student=studentMapper.getStudentById("102");
        student.fillScore();
        student.showWithScore();
    }
    /**
     * 依据学号查询学生
     */
    @Test
    public void testGetStudentByID()
    {
        Student student =studentMapper.getStudentById("103");
        student.showMessage();
    }

    /**
     * 更改学生信息
     */
    @Test
    public void testUpdateStudent() {
        Student student=studentMapper.getStudentById("103");
        student.setName("老高5");
        int i= studentMapper.updateStudent(student);
        System.out.println("更新数据："+i+"条");
    }

    /**
     * 新增学生信息
     */
    @Test
    public void testInsertStudent() {
        Student student=new Student("106","钱八","男", LocalDate.of(1999,9,9));
        int i= studentMapper.insertStudent(student);
        System.out.println("插入数据："+i+"条");
    }
    /**
     * 按学生平均成绩排序信息
     */
    @Test
    public void testGetAllStudent()
    {
        ExCollection<Student> allStudent =studentMapper.getAllStudent();
        allStudent.forEach(s->{
            s.fillScore();
        });
        allStudent.sort((s1,s2)->s1.getAvgScore().compareTo(s2.getAvgScore()))
                .forEach(Student::showWithScore);
    }

    /**
     * 获取姓“小”的学生
     */
    @Test
    public void testGetStudentByName()
    {
        ExCollection<Student> allStudent =studentMapper.getStudentByName("小");
        allStudent.forEach(Student::showWithScore);
    }

}
