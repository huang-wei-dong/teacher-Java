package cn.jyd.six;
/**
 * 有序集合
 */
public class OrderlyCollection<T extends Comparable<T>> extends BaseCollection<T> {
    public OrderlyCollection(int capacity) {
        super(capacity);
    }

    public OrderlyCollection(T[] arrays){
        super(arrays);
    }

    @Override
    public void add(T obj) {
        int i = getSize() - 1;
        while (i >= 0 && obj.compareTo((T)super.arrays[i]) < 0) {
            arrays[i + 1] = arrays[i];
            i--;
        }
        arrays[i + 1] = obj;
        size++;
    }
}
