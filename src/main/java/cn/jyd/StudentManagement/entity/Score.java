package cn.jyd.StudentManagement.entity;

import cn.jyd.StudentManagement.mapper.CourseMapper;
import cn.jyd.StudentManagement.mapper.StudentMapper;
import cn.jyd.five.Student;

/**
 * 成绩类
 */
public class Score {
    private int courseID;
    private String studentID;
    private double score;//分数

    private Student student;//学生
    private Course course;//课程

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Score() {
    }

    public Score(int courseID, String studentID, double score) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.score = score;
    }

    public Student getStudent(Boolean refresh) {
        if(student==null || refresh)
            student = new StudentMapper().getStudentById(studentID);
        return student;
    }

    public Course getCourse(Boolean refresh) {
        if(course==null || refresh)
            course = new CourseMapper().getCourseById(courseID);
        return course;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public void show(){
        System.out.println("学生ID："+studentID+"  课程ID："+courseID+"  成绩："+score);
    }
    public void showWithStudent(){
        System.out.println("学生："+student.getName()+"  课程："+course.getCourseName()+"  成绩："+score);
    }
}
