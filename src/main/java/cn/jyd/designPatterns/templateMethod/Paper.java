package cn.jyd.designPatterns.templateMethod;

import java.util.ArrayList;
import java.util.List;
/**
 * 试卷类
 */
public class Paper {
    private String title;          // 试卷标题
    private String studentName;    // 学生姓名
    private List<Question> questions = new ArrayList<>();// 题目
    private int totalScore;         // 总分

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
