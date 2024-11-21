package cn.jyd.eight;

public interface Interceptor<T> {
    void before(T item);
    void after(T item);
}
