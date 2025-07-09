package cn.jyd.designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;
/**
 *具体主题类
 */
public class NewsPublisher implements Subject {
    //观察者列表
    private final List<Observer> observers = new ArrayList<>();
    private String news;//主题新闻
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        //遍历观察者列表，通知所有观察者
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
    //发布新闻
    public void publishNews(String news) {
        this.news = news;
        notifyObservers();//通知所有观察者
    }
}
