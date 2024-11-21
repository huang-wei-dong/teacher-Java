package cn.jyd.StudentManagement.mapper;

import cn.jyd.StudentManagement.entity.Course;
import cn.jyd.fifteen.ExCollection;
import cn.jyd.sixteen.MysqlHelp;
import java.sql.ResultSet;

/**
 * 课程类映射器
 */
public class CourseMapper {
    /**
     * 依据sql语句获取课程信息
     */
    private ExCollection<Course> getCourseBySql(String sql) {
        ExCollection<Course> allCourses = new ExCollection<>();
        ResultSet rs = MysqlHelp.getInstance().getResultSet(sql);
        try {
            while (rs.next()) {
                allCourses.add(new Course(rs.getInt("courseId"),
                        rs.getString("course_name"),
                        rs.getString("teacher")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return allCourses;
    }
    /**
     * 获取所有课程
     */
    public ExCollection<Course> getAllCourse() {
        return getCourseBySql("select * from course");
    }
    /**
     * 依据课程编号获取课程
     */
    public Course getCourseById(int courseId) {
        String sql = "select * from course where courseId = " + courseId;
        return getCourseBySql(sql).getIndexOf(0);
    }
    /**
     * 依据课程名称获取课程
     */
    public ExCollection<Course> getCourseByName(String courseName) {
        String sql = "select * from course where course_name like '%" + courseName + "%'";
        return getCourseBySql(sql);
    }
    /**
     * 更改课程信息
     */
    public int updateCourse(Course course) {
        String sql = "update course set course_name = '" + course.getCourseName()
                + "', teacher = '" + course.getTeacher()
                + "' where courseId = " + course.getCourseId();
        return MysqlHelp.getInstance().executeUpdate(sql);
    }
    /**
     * 插入课程信息
     */
    public int insertCourse(Course course) {
        String sql = "insert into course(course_name, teacher) values('"
                + course.getCourseName() + "', '" + course.getTeacher() + "')";
        return MysqlHelp.getInstance().executeUpdate(sql);
    }
    /**
     * 删除课程信息
     */
    public int deleteCourse(int courseId) {
        String sql = "delete from course where courseId = " + courseId;
        return MysqlHelp.getInstance().executeUpdate(sql);
    }
}
