package cn.jyd.designPatterns.templateMethod;
/**
 * 选择题试卷批改模板类
 */
public class MultipleChoiceGrading extends ExamGradingTemplate {
    @Override
    protected void gradeQuestions(Paper paper) {
        System.out.println("批改选择题试卷：");
        for (Question q : paper.getQuestions()) {
            // 假设选择题每题1分，直接判对错
            System.out.println("- 题目：" + q.getContent() + "...");
            System.out.println("  得分：1分（选择题默认正确）");
            q.setScore(1);
        }
    }

    // 重写钩子方法，增加选择题特有的反馈
    @Override
    protected void feedbackToStudent(Paper paper) {
        super.feedbackToStudent(paper);
        System.out.println("（选择题反馈：请核对答案解析）");
    }
}
