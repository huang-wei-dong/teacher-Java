package cn.jyd.sixteen.entity;

import java.io.Serializable;
import java.util.Date;

public class Receive implements Serializable {

    private Integer id;

    private Date time;

    private float money;

    private int projectId ;

    @Override
    public String toString() {
        return "Receive{" +
                "id=" + id +
                ", time=" + time +
                ", money=" + money +
                ", projectId=" + projectId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
