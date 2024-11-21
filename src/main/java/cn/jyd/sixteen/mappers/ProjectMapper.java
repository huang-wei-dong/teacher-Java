package cn.jyd.sixteen.mappers;

import cn.jyd.sixteen.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProjectMapper {
    /*
    * 依据ID查询项目*/
    Project getProjectById(Integer id);
    /*
    * 查询销售员所销售项目*/
    List<Project> getProjectBySalesIdId(Integer salesId);
    /*
    * 名字匹配项目*/
    List<Project> getProjectByProjectName(String projectName);
//    依据ID，项目名，销售ID综合查询
    List<Project> getProjectByFilter(Integer projectId,String projectName,Integer salesId);
    /*
    *新增项目*/
    int insertProject(Project project);
    /*更新项目*/
    int updateProject(Project project);
    /*依据ID删除项目*/
    int deleteProject(Integer id);
    /*
    * 获取全部项目*/
    List<Project> getAllProject();
}
