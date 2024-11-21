package cn.jyd.eight;

public class MyUniqueCollection<T> extends MyArrayCollection<T> {
    @Override
    public boolean add(T t) {
        if(contains(t)){
            return false;
        }
        return super.add(t);
    }
    public MyUniqueCollection(int capacity) {
        super(capacity);
    }
    public MyUniqueCollection() {
        super();
    }
}
