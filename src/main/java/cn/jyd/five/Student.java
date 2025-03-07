package cn.jyd.five;

import cn.jyd.StudentManagement.entity.Score;
import cn.jyd.StudentManagement.mapper.ScoreMapper;
import cn.jyd.fifteen.ExCollection;
import cn.jyd.four.Person;
import java.time.LocalDate;

/**
 * 学生类
 */
public class Student extends Person implements Comparable<Student> {
    private int score;//成绩，学生类特有的属性


    public Student(String cardId, String name, String sex, LocalDate birthday) {
        super(cardId, name, sex, birthday);
    }

    public Student(String cardId,String name, String sex,LocalDate birthday, int score) {
        //调用父类的构造方法
        super(cardId, name, sex, birthday);
        this.score = score;
    }

    private ExCollection<Score> scoresDB;

    public Student() { }

    /**
     *按成绩比较
     */
    @Override
    public int compareTo(Student s) {
        return getScore()-s.getScore();
    }

    public int getScore() {
        return score;
    }

    /**
     * 该学生的所有成绩
     */
    private ExCollection<Score> scores;
    //获取所有成绩
    public ExCollection<Score> getScores() {
        return scores;
    }

    //重写toString方法
    @Override
    public String toString() {
        return super.toString()+
                "Student{" +
                "score=" + score +
                "} ";
    }

    //重写showMessage方法
    public void showMessage() {
        super.showMessage();
    }
    @Override
    public void planWork() {
        System.out.println("学生:"+getName()+"正在计划学习");
    }
    @Override
    public void doWork() {
        System.out.println("学生:"+getName()+"正在学习");
    }
    @Override
    public void workResult(String result) {
        System.out.println("学生:"+getName()+"学习结果："+getScore() + result);
    }

    /**
     * 获取最高成绩
     * @return 最高成绩
     */
    public Double getMaxScore(){
        return scores.max(Score::getScore);
    }
    /**
     * 获取平均成绩
     * @return 平均成绩
     */
    public Double getAvgScore(){
        return scores.avg(Score::getScore);
    }
    /**
     * 获取最低成绩
     * @return 最低成绩
     */
    public Double getMinScore(){
        return scores.min(Score::getScore);
    }
    /**
     * 获取总成绩
     * @return 总成绩
     */
    public Double getSumScore(){
        return scores.sum(Score::getScore);
    }
    /**
     * 筛选不及格课程
     * @return
     */
    public ExCollection<Score> getFailScores(){
        return scores.where(s->s.getScore()<60);
    }
    public void show(){
        System.out.println(this);
    }

    public void showWithScore() {
        super.showMessage();//显示基本信息
        showScores();//显示成绩
    }
    /**
     * 显示所有成绩
     */
    public void showScores(){
        if(getScores()==null || getScores().isEmpty()){
            System.out.println("学生暂无成绩");
            return;
        }
        System.out.println("---各科成绩列表：---");
        getScores().forEach(s->System.out.printf("%4s:%3.1f\n"
                ,s.getCourse(false).getCourseName(),s.getScore()));
        System.out.println("---成绩汇总：---");
        System.out.println("最高成绩："+getMaxScore());
        System.out.println("最低成绩："+getMinScore());
        System.out.println("总 成 绩："+getSumScore());
        System.out.printf("平均成绩：%.2f\n",getAvgScore());
        if(getFailScores()!=null && !getFailScores().isEmpty() ) {
            System.out.println("---不及格成绩：---");
            getFailScores().forEach(Score::show);
        }
    }

    /**
     * 填充学生成绩
     */
    public void fillScore() {
        if(scores==null){
            scores= new ScoreMapper().getScoreByStudentID(getCardId());
        }
    }
}
