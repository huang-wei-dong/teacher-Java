package cn.jyd.sixteen.entity;


import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private int userId;
    private String name;
    private String sex;
    //一个员工多个项目
    private List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }





    @Override
    public String toString() {
        return "Employee{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", projectlist=" + projectList +
                '}';
    }
}
