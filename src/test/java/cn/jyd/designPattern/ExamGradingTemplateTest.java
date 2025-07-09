package cn.jyd.designPattern;

import cn.jyd.designPatterns.templateMethod.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExamGradingTemplateTest {
    /**
     * 模板方法模式测试
     */
    @Test
    public void examGradingTemplateTest()
    {
        // 创建选择题试卷
        Paper mcPaper = createMultipleChoicePaper();
        ExamGradingTemplate mcGrader = new MultipleChoiceGrading();
        mcGrader.gradeExam(mcPaper);
        System.out.println("-------------------");
        // 创建主观题试卷
        Paper essayPaper = createEssayPaper();
        ExamGradingTemplate essayGrader = new EssayGrading();
        essayGrader.gradeExam(essayPaper);
    }
    // 创建主观题试卷
    private Paper createEssayPaper() {
        Paper paper = new Paper();
        paper.setTitle("主观题");
        paper.setStudentName("李四");
        paper.setQuestions(List.of(
                new Question("请编写Hello world程序。", 10),
                new Question("请回答软件工程研究内容。", 10),
                new Question("请说明软件开发主要过程。", 10)
        ));
        paper.setTotalScore(0);
        return paper;
    }
    // 创建选择题试卷
    private Paper createMultipleChoicePaper() {
        Paper paper = new Paper();
        paper.setTitle("选择题");
        paper.setStudentName("张三");
        paper.setQuestions(List.of(
                new Question("1+1=?", 5),
                new Question("2+2=?", 5),
                new Question("3+3=?", 5)
        ));
        paper.setTotalScore(0);
        return paper;
    }
}
