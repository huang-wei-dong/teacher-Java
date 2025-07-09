package cn.jyd.designPatterns.templateMethod;

/**
 * 14
 */
public abstract class  ExamGradingTemplate {
    // 模板方法：定义评分的标准流程
    public final void gradeExam(Paper paper) {
        distributePaper(paper);      // 1. 分发试卷
        gradeQuestions(paper);       // 2. 题目评分（抽象方法）
        calculateTotalScore(paper);  // 3. 计算总分
        recordScore(paper);          // 4. 成绩登记
        feedbackToStudent(paper);    // 5. 结果反馈，子类可重写
    }
    // 分发试卷（所有考试通用）
    private void distributePaper(Paper paper) {
        System.out.println("分发试卷：" + paper.getTitle());
    }
    // 题目评分（由子类实现）
    protected abstract void gradeQuestions(Paper paper);
    // 计算总分（所有考试通用）
    private void calculateTotalScore(Paper paper) {
        int total = 0;
        for (Question q : paper.getQuestions()) {
            total += q.getScore();
        }
        paper.setTotalScore(total);
        System.out.println("计算总分：" + total + "分");
    }
    // 成绩登记（所有考试通用）
    private void recordScore(Paper paper) {
        System.out.println("登记成绩：" + paper.getStudentName() + "，总分：" + paper.getTotalScore());
    }
    // 钩子方法：结果反馈（子类可选重写）
    protected void feedbackToStudent(Paper paper) {
        System.out.println("向学生 " + paper.getStudentName() + " 反馈成绩");
    }
}
