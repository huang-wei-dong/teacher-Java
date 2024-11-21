package cn.jyd.StudentManagement.entity;

import cn.jyd.StudentManagement.mapper.ScoreMapper;
import cn.jyd.fifteen.ExCollection;

/*
 * 课程类
 */
public class Course {
    private int courseId;//课程号
    private String courseName;//课程名
    private String teacher;//教师
    private ExCollection<Score> scores =null;//课程所有成绩

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(){}
    public Course(int courseId, String courseName, String teacher){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    /**
     * 填充课程成绩
     * @return
     */
    public ExCollection<Score> getScore(){
        if(scores==null)
            scores= new ScoreMapper().getScoreByCourseID(courseId);
        return scores;
    }

    /**
     * 显示课程信息
     */
    public void show(){
        System.out.printf("课程号：%d  课程名：%-10s  教师：%-5s\n"
                ,courseId,courseName,teacher);
    }

    public void showWithScore(){
        show();
        getScore().forEach(Score::show);
        System.out.println("---------课程统计信息-----------");
        System.out.printf("平均分：%.2f  最高分：%.2f  最低分：%.2f  总人数：%d\n"
                ,getAvg(),getMax(),getMin(),getCount());
        System.out.println("---------课程信息显示完毕-----------");
    }
    public double getAvg(){
        return getScore().avg(Score::getScore);
    }
    public double getMax(){
        return getScore().max(Score::getScore);
    }
    public double getMin(){
        return getScore().min(Score::getScore);
    }
    public int getCount(){
        return getScore().size();
    }
}
