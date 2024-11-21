package cn.jyd.six;

//集合类，不允许重复元素
public class UniqueCollection<T> extends BaseCollection<T>{
    UniqueCollection(int capacity){
        super(capacity);
    }
    @Override
    public void add(T o){
        if(!super.contains(o)){
            super.add(o);
        }
    }
}
