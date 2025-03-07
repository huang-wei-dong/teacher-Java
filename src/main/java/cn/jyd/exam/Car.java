package cn.jyd.exam;

/**
 * 轿车类
 */
public class Car {
    private Engine engine;
    private Gearbox gearbox;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }
    public void show()
    {
        System.out.println("发动机功率："+engine.getPower());
        System.out.println("变速箱档位："+gearbox.getAmount());
    }
}
