package cn.jyd.seven;

/**
 *选择接口，选择满足条件的值返回true，否则返回false
 */
public interface Condition<T> {
    /**
     * 判断是否满足条件
     * @param item 需要判断的元素
     * @return true：满足，false：不满足
     */
    boolean accept(T item);
}
