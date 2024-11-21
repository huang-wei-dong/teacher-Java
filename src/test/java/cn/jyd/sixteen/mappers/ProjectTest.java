package cn.jyd.sixteen.mappers;

import cn.jyd.sixteen.entity.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ProjectTest {

    private  SqlSessionFactory  sqlSessionFactory;
    @BeforeEach
    void setUpBeforeClass() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getProjectByIdTest(){
        try(SqlSession  sqlSession=sqlSessionFactory.openSession()) {
            //Project project=sqlSession.selectOne("cn.kr.project.mappers.ProjectMapper.getProjectById",1);
            Project project=sqlSession.getMapper(ProjectMapper.class).getProjectById(1);
            System.out.println(project);
        }
    }

    @Test
    public void getProjectByFilterTest(){
        try(SqlSession  sqlSession=sqlSessionFactory.openSession()) {
            List<Project> project=sqlSession.getMapper(ProjectMapper.class)
                    .getProjectByFilter(1,"实验室",1);
            System.out.println(project);
        }
    }

    @Test
    public void updateTest() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Project project=sqlSession.getMapper(ProjectMapper.class).getProjectById(1);
            project.setAmount(3002);
            System.out.println(project);
            int i = sqlSession.update("updateProject", project);
            sqlSession.commit();
        }
    }

    @Test
    public void insertTest() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Project project=new Project();
            project.setAmount(120000);
            project.setProjectName("人事信息化项目");
            project.setSalesId(1);
            project.setDate(new Date(2024,7,3));
            System.out.println(project);
            ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
            //projectMapper.insertProject(project);
            sqlSession.commit();
        }
    }

    @Test
    public void deleteTest() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ProjectMapper projectMapper=sqlSession.getMapper(ProjectMapper.class);
            int i = projectMapper.deleteProject(5);
            sqlSession.commit();
        }
    }
}
