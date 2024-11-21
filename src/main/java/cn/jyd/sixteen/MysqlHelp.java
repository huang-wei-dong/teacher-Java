package cn.jyd.sixteen;

import java.sql.*;
/**
 * Mysql数据库连接工具类
 */
public class MysqlHelp {
    private String url;
    private String user;
    private String password;
    private String driver;
    private String useSSL;
    private static MysqlHelp instance=null;
    // 单例模式
    public static MysqlHelp getInstance(){
        if(instance==null){
            instance = new MysqlHelp();
        }
        return instance;
    }
    /**
     * 私有化构造方法
     * 注意其中的url、user、password需要根据自己的MySql配置进行更改
     */
    private MysqlHelp(){
        url = "jdbc:mysql://localhost:3306/student_manage?";
        user = "root";
        password = "123456";
        driver = "com.mysql.cj.jdbc.Driver";
        useSSL = "useSSl=false&serverTimezone=GMT&characterEncoding=utf-8";
        instance = this;
    }

    /**
     * 获取连接
     * @return 数据库连接
     */
    private Connection getConnection(){
        try {
            return DriverManager.getConnection(url+useSSL,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 获取Statement对象
     * @return
     */
    public Statement getSqlStatement(){
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 获取数据集,select
     * @param sql: sql语句
     */
    public ResultSet getResultSet(String sql){
        try {
            return getSqlStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 执行更新语句insert、update、delete
     * @param sql: sql语句
     * return:返回影响的行数
     */
    public int executeUpdate(String sql){
        try {
            return getSqlStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行事务
     */
    public void executeTransaction(String ...sql){
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);//设置手动提交
            Statement statement = connection.createStatement();
            try {
                for (String s:sql){
                    statement.executeUpdate(s);
                }
                connection.commit();//提交事务
                System.out.println("数据库执行成功");
            }catch (SQLException e){
                connection.rollback();//回滚
                System.out.println("数据库执行失败，已回滚");
            }
            finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
