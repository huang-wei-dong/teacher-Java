package cn.jyd.designPatterns.observerPattern;
/**
 * 观察者接口
 */
public interface Observer {
    /**
     * 方法观察者收到消息的 处理反应
     */
    void update(String message);
}
