package cn.jyd.StudentManagement;

import cn.jyd.StudentManagement.entity.Course;
import cn.jyd.StudentManagement.mapper.CourseMapper;
import cn.jyd.fifteen.ExCollection;
import org.junit.Test;

public class TestCourse {
    CourseMapper courseMapper = new CourseMapper();
    /**
     * 获取所有课程
     */
    @Test
    public void testGetAllCourse() {
        ExCollection<Course> courses = courseMapper.getAllCourse();
        courses.forEach(Course::show);
    }
    /**
     * 获取所有课程,并显示课程成绩
     */
    @Test
    public void testGetAllCourseWithScore() {
        ExCollection<Course> courses = courseMapper.getAllCourse();
        courses.forEach(Course::showWithScore);
    }

    /**
     * 依据课程号获取课程
     */
    @Test
    public void testGetCourse() {
        Course course = courseMapper.getCourseById(1);
        course.showWithScore();
    }
    /**
     * 依据课程名获取课程
     */
    @Test
    public void testGetCourseByName() {
        ExCollection<Course> courses = courseMapper.getCourseByName("程序设计");
        courses.forEach(Course::showWithScore);
    }

    /**
     * 插入课程
     */
    @Test
    public void testInsertCourse() {
        Course course = new Course();
        course.setCourseName("Java程序设计");
        course.setTeacher("王老师");
        int result = courseMapper.insertCourse(course);
        System.out.println("影响条数："+result);
    }
    /**
     * 更新课程
     */
    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        course.setCourseId(7);
        course.setCourseName("Java程序设计");
        course.setTeacher("李老师");
        int result = courseMapper.updateCourse(course);
        System.out.println("影响条数："+result);
    }
}
