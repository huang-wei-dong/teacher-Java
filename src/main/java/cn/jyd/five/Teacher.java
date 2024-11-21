package cn.jyd.five;

import cn.jyd.four.Person;
import java.time.LocalDate;

//老师类
public class Teacher extends Person {
    //授课学时
    private int teachingHours;

    public Teacher()
    {
        super();
    }
    public Teacher(String cardId, String name,
                   String sex, LocalDate birthday,
                   int teachingHours)
    {
        super(cardId, name, sex, birthday);
        this.teachingHours = teachingHours;
    }
    public int getTeachingHours()
    {
        return teachingHours;
    }
    public void setTeachingHours(int teachingHours)
    {
        this.teachingHours = teachingHours;
    }
    @Override
    public void showMessage()
    {
        System.out.println("我是老师：");
        super.showMessage();
        System.out.println("授课学时：" + teachingHours);
    }
    @Override
    public void workResult(String result)
    {
        System.out.println("老师：" + getName() + "老师，" + result);
    }
    @Override
    public void doWork()
    {
        System.out.println("老师：" + getName() + "老师，正在授课，请大家Come on！");
    }
    @Override
    public void planWork()
    {
        System.out.println("老师：" + getName() + "老师，明天要开课，请大家做好准备！");
    }


}
