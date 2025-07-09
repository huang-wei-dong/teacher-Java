package cn.jyd.designPatterns.templateMethod;
/**
 * 主观题评分
 */
public class EssayGrading extends ExamGradingTemplate {
    @Override
    protected void gradeQuestions(Paper paper) {
        System.out.println("批改主观题试卷：");
        for (Question q : paper.getQuestions()) {
            // 主观题需要人工评分（此处简化为随机给分）
            int score = (int) (Math.random() * 10) + 1; // 1-10分
            System.out.println("- 题目：" + q.getContent() + "...");
            System.out.println("  得分：" + score + "分（主观题人工评分）");
            q.setScore(score);
        }
    }
}
