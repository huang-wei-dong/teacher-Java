package cn.jyd.sixteen;

import org.junit.Test;

public class TestSql {
    /**
     * 测试执行数据库事务
     */
    @Test
    public void testTransaction() {
        String sql1 = "update student set name='小彭' where card_id='103'";
        String sql2 = "insert into student(card_id,name,sex,birthday) "+
                "values('104','小明','男','1995-01-01')";
        MysqlHelp.getInstance().executeTransaction(sql1,sql2);
    }

}
