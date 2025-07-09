package cn.jyd.designPatterns.observerPattern;
/**
 * 具体观察者
 */
public class NewsReader implements Observer {
    private final String name;

    public NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到新闻：" + message);
    }
}
