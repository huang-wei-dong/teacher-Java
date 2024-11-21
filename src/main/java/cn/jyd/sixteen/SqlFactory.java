package cn.jyd.sixteen;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlFactory {
    static private SqlSessionFactory sqlSessionFactory=null;

    public static SqlSessionFactory getSqlSessionFactory () throws Exception {
        if(sqlSessionFactory==null){
            String resource = "mybatis-config.xml";
            InputStream inputStream= Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }
}
