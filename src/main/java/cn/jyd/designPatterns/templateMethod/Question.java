package cn.jyd.designPatterns.templateMethod;
/**
 * 考试题目类
 */
public class Question {
    private String content;        // 题目内容
    private int score;             // 题目分数

    public Question(String s, int i) {
        content = s;
        score = i;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
