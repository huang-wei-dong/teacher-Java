package cn.jyd.StudentManagement.mapper;

import cn.jyd.fifteen.ExCollection;
import cn.jyd.five.Student;
import cn.jyd.sixteen.MysqlHelp;
import java.sql.ResultSet;

/**
 * 学生数据库映射类
 */
public class StudentMapper {
    /**
     * 根据sql语句获取学生信息
     * @param sql 查询语句
     * @return 学生对象集合
     */
    private ExCollection<Student> getStudents(String sql) {
        ExCollection<Student>  allStudents=new ExCollection<>();
        ResultSet rs= MysqlHelp.getInstance().getResultSet(sql);
        try {
            while (rs.next()) {
                allStudents.add(
                        new Student(rs.getString("card_Id"),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDate("birthday").toLocalDate()));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allStudents;
    }
    /**
     * 根据学号获取学生信息
     * @param cardId 身份证
     * @return 学生对象实例
     */
    public Student getStudentById(String cardId) {
        String sql = "select * from student where card_id = '" + cardId + "'";
        return getStudents(sql).getIndexOf(0);
    }

    /**
     * 获取所有学生信息
     * @return 学生对象集合
     */
    public ExCollection<Student> getAllStudent() {
        String sql = "select * from student";
        return getStudents(sql);
    }
    /**
     * 根据学生姓名获取学生信息
     * @param name 学生姓名
     * @return 学生对象集合
     */
    public ExCollection<Student> getStudentByName(String name) {
        String sql = "select * from student where name like '%" + name + "%'";
        return getStudents(sql);
    }

    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 影响的行数
     */
    public int updateStudent(Student student) {
        String sql="update student set ";
        sql+="name='"+student.getName()+"',";
        sql+="sex='"+student.getSex()+"',";
        sql+="birthday='"+student.getBirthday()+"' ";
        sql+="where card_Id='"+student.getCardId()+"'";
        return MysqlHelp.getInstance().executeUpdate(sql);
    }

    /**
     * 插入学生信息
     * @param student 学生对象
     * @return 影响的行数
     */
    public int insertStudent(Student student) {
        String sql="insert into student (card_Id,name,sex,birthday) values(";
        sql+="'"+student.getCardId()+"',";
        sql+="'"+student.getName()+"',";
        sql+="'"+student.getSex()+"',";
        sql+="'"+student.getBirthday()+"')";
        return MysqlHelp.getInstance().executeUpdate(sql);
    }

    /**
     * 删除学生信息
     * @param cardId 学生身份证
     * @return  返回影响的行数
     */
    public int deleteStudentById(String cardId) {
        String sql="delete from student where card_Id='"+cardId+"'";
        return MysqlHelp.getInstance().executeUpdate(sql);
    }
}
