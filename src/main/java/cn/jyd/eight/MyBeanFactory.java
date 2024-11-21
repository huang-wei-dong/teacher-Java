package cn.jyd.eight;

import cn.jyd.seven.*;
import cn.jyd.six.BaseCollection;

public class MyBeanFactory {
    // 根据类名获取实例
    // 返回值类型为实现Shapes接口的类
    public Shapes getShapesBean(String className){
        switch (className){
            case "cn.jyd.seven.Circle":
                return new Circle(2.0);
            case "cn.jyd.seven.Square":
                return new Square(2.0);
            case "cn.jyd.seven.Rectangle":
                return new Rectangle(2.0,3.0);
            default:
                return null;
        }
    }
    public Work getWorkBean(String className){
        switch (className){
            case "cn.jyd.seven.Staff":
                return new Staff();
            default:
                return null;
        }
    }
    public BaseCollection<Shapes> getShapesCollectionBean(){
        return new BaseCollection<Shapes>();
    }
}
