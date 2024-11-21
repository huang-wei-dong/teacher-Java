package cn.jyd.StudentManagement.mapper;

import cn.jyd.StudentManagement.entity.Score;
import cn.jyd.fifteen.ExCollection;
import cn.jyd.sixteen.MysqlHelp;
import java.sql.ResultSet;

public class ScoreMapper {
    /**
     * 从数据库获取成绩
     * @param sql 查询语句,  例如：select * from score
     * @return 成绩集合
     */
    private ExCollection<Score> getScores(String sql) {
        ExCollection<Score> scores = new ExCollection<Score>();
        ResultSet rs= MysqlHelp.getInstance().getResultSet(sql);
        try {
            while (rs.next()) {
                int courseID = rs.getInt("courseID");
                String studentID = rs.getString("studentID");
                double score = rs.getDouble("score");
                scores.add(new Score(courseID,studentID,score));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return scores;
    }
    /**
     * 根据课程号和学生号查找成绩
     * @param courseID 课程号
     * @param studentID 学生号
     * @return
     */
    public Score getScore(int courseID, String studentID)
    {
        String sql = "select * from score where courseID="+courseID
                + " and studentID="+studentID;
        return getScores(sql).getIndexOf(0);
    }

    /**
     * 依据课程号获取成绩
     * @param courseID 课程号
     */
    public ExCollection<Score> getScoreByCourseID(int courseID)
    {
        String sql = "select * from score where courseID="+courseID;
        return getScores(sql);
    }

    /**
     * 依据学生号获取成绩
     * @param studentID 学生号
     */
    public ExCollection<Score> getScoreByStudentID(String studentID)
    {
        String sql = "select * from score where studentID="+studentID;
        return getScores(sql);
    }

    /**
     * 获取所有成绩
     */
    public ExCollection<Score> getAllScore()
    {
        String sql = "select * from score";
        return getScores(sql);
    }
    /**
     * 插入一条成绩记录
     * @param score 成绩对象
     */
    public int insertScore(Score score)
    {
        String sql = "insert into score(courseID,studentID,score) values("
                +score.getCourseID()+","+score.getStudentID()+","+score.getScore()+")";
        return MysqlHelp.getInstance().executeUpdate(sql);
    }

    /**
     * 修改成绩
     */
    public int updateScore(Score score)
    {
        String sql = "update score set score="+score.getScore()
                +" where courseID="+score.getCourseID()+" and studentID="+score.getStudentID();
        return MysqlHelp.getInstance().executeUpdate(sql);
    }

    /**
     * 删除一条成绩记录
     * @param courseID 课程号
     * @param studentID 学生号
     */
    public int deleteScore(int courseID, String studentID)
    {
        String sql = "delete from score where courseID="+courseID+" and studentID="+studentID;
        return MysqlHelp.getInstance().executeUpdate(sql);
    }


}
