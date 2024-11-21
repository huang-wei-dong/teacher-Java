package cn.jyd.fifteen;
/**
 * 获取键的接口
 * @param <T> 返回的键类型
 * @param <E> 用于返回键的元素类型
 */
public interface GetKey<T,E> {
    public T getKey(E e);
}
