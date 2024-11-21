package cn.jyd.sixteen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Project implements Serializable {
    private Integer projectId;
    private String projectName;
    private float amount;
    private int salesId    ;
    private Date date;
    private Employee sales;
    private List<Receive> receive ;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getSales() {
        return sales;
    }

    public void setSales(Employee sales) {
        this.sales = sales;
    }

    public List<Receive> getReceive() {
        return receive;
    }

    public void setReceive(List<Receive> receive) {
        this.receive = receive;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", amount=" + amount +
                ", salesId=" + salesId +
                ", date=" + date +
                ", sales=" + sales +
                ", receive=" + receive +
                '}';
    }
}
