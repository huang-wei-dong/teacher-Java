package cn.jyd.fifteen;
/**
 * 获取数值的接口
 * @param <E>
 */
public interface GetNumber<E> {
    /**
     * 获取数字
     * @param element 从该元素获取数值
     * @return 数值
     */
    double getNumber(E element);
}
