package cn.jyd.designPattern;

import cn.jyd.designPatterns.observerPattern.NewsPublisher;
import cn.jyd.designPatterns.observerPattern.NewsReader;
import org.junit.jupiter.api.Test;

public class ObserverTest {
    @Test
    public void observerTest() {
        // 创建发布者
        NewsPublisher publisher = new NewsPublisher();
        // 创建2个观察者
        NewsReader reader1 = new NewsReader("张三");
        NewsReader reader2 = new NewsReader("李四");
        // 注册观察者
        publisher.registerObserver(reader1);
        publisher.registerObserver(reader2);
        // 发布新闻，观察者收到新闻
        publisher.publishNews("今日股市大涨！");
        // 输出：
        // 张三 收到新闻：今日股市大涨！
        // 李四 收到新闻：今日股市大涨！
    }
}
