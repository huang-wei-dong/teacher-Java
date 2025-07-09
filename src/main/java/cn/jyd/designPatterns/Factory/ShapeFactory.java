package cn.jyd.designPatterns.Factory;
/**
 * 简单形状工厂类
 */
public class ShapeFactory {
    /**
     * 根据传入的参数创建对应的形状对象
     * @param type：需要实现接口的类名
     * @return Shape接口实现类
     */
    public static Shape createShape(String type) {
       switch (type.toLowerCase()) {
           case "circle" :
               return new Circle();
            case "rectangle":
                return new Rectangle();
           default :
               throw new IllegalArgumentException("未知形状类型：" + type);
        }
    }
}
