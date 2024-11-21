package cn.jyd.StudentManagement;

import cn.jyd.StudentManagement.entity.Score;
import cn.jyd.StudentManagement.mapper.ScoreMapper;
import cn.jyd.fifteen.ExCollection;
import org.junit.Test;

public class TestScore {
    private ScoreMapper scoreMapper = new ScoreMapper();
    /**
     * 测试获取所有成绩
     */
    @Test
    public void testGetAllScore() {
        ExCollection<Score> allScore = scoreMapper.getAllScore();
        allScore.forEach(Score::show);
    }
    /**
     * 测试通过学号获取成绩
     */
    @Test
    public void testGetScoreByStudentID() {
        ExCollection<Score> scoreByStudentID =
                scoreMapper.getScoreByStudentID("101");
        scoreByStudentID.forEach(Score::show);
    }
    /**
     * 测试通过课程ID获取成绩
     */
    @Test
    public void testGetScoreByCourseID() {
        ExCollection<Score> scoreByCourseID = scoreMapper.getScoreByCourseID(2);
        scoreByCourseID.forEach(Score::show);
    }
    /**
     * 测试通过学号、课程号获取成绩
     */
    @Test
    public void testGetScore() {
        Score score = scoreMapper.getScore(2, "101");
        score.show();
    }

    /**
     * 新增学生成绩
     */
    @Test
    public void testInsertScore() {
        Score score = new Score(7, "101", 90);
        int i = scoreMapper.insertScore(score);
        System.out.println("影响条数："+i);
    }

    /**
     * 更新学生成绩
     */
    @Test
    public void testUpdateScore() {
        Score score = new Score(7, "101", 99);
        int i = scoreMapper.updateScore(score);
        System.out.println("影响条数："+i);
    }

}
