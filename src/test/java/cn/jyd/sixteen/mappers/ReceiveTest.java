package cn.jyd.sixteen.mappers;


import cn.jyd.sixteen.SqlFactory;
import cn.jyd.sixteen.entity.Receive;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


public class ReceiveTest {

    @Test
    void selectById() throws Exception {
        try(SqlSession sqlSession=SqlFactory.getSqlSessionFactory().openSession()) {
            ReceiveMapper receiveMapper=sqlSession.getMapper(ReceiveMapper.class);
            Receive receive= (Receive) receiveMapper.getReceiveById(1);
            System.out.println(receive);
        }
    }
    @Test
    void insertReceiveTest() throws Exception {
        try(SqlSession sqlSession=SqlFactory.getSqlSessionFactory().openSession()){
            ReceiveMapper receiveMapper=sqlSession.getMapper(ReceiveMapper.class);
            Receive receive=new Receive();
            receive.setMoney(1000);
            receive.setProjectId(1);
            receiveMapper.insertReceive(receive);
            sqlSession.commit();
        }
    }

}
