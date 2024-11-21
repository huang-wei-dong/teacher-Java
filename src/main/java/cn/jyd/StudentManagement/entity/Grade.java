package cn.jyd.StudentManagement.entity;

import cn.jyd.eight.MyArrayCollection;
import cn.jyd.five.Student;

/**
 * 年级类
 */
public class Grade {
    private String gradeId;
    private String gradeName;
    private MyArrayCollection<Student> students;

    public Grade() {
    }

    public Grade(String gradeId, String gradeName, MyArrayCollection<Student> students) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.students = students;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public MyArrayCollection<Student> getStudents() {
        return students;
    }

    public void setStudents(MyArrayCollection<Student> students) {
        this.students = students;
    }
}
