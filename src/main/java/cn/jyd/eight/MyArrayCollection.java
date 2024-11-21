package cn.jyd.eight;

import cn.jyd.seven.Condition;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
/**
 * 自定义泛型集合类，采用数组实现
 * @param <T>   集合元素类型
 */
public class MyArrayCollection<T> implements Collection<T> {
    private T[] array;//数组，用于存储集合元素
    private int size;//元素个数
    private int capacity;//容量
    
    public MyArrayCollection(T[] array){
        capacity = array.length;
        this.array = array;
        for (int i=0;i<array.length;i++){
            if(array[i]!=null){
                size++;
            }
        }
    }
    public MyArrayCollection(){
        array = (T[]) new Object[8];
        size=0;
        this.capacity = 8;
    }
    public MyArrayCollection(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        if(size>0){
            return array;
        }
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        int arrayLength = array.length;
        T1[] array2 = (T1[]) new Object[arrayLength];
        System.arraycopy(array,0,array2,0,arrayLength);
        return array2;
    }

    @Override
    public boolean add(T t) {
        if(size<capacity){
            array[size++] = t;
        }else {
            extracted();
            add(t);
        }
        return true;
    }
    //数组扩容
    private void extracted() {
        capacity = capacity*2;
        T[] array2= (T[]) new Object[capacity];
        for (int i=0;i<array.length;i++){
            array2[i] = array[i];
        }
        array = array2;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index!=-1){
            return false;
        }else {
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[--size] = null;
            return true;
        }
    }

    public int indexOf(Object o){
        for(int i=0;i<size;i++){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o:c){
            if(!this.contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = true;
        for(T t:c){
            flag=flag && add(t);
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = true;
        for(Object o:c){
            flag=flag && remove(o);
        }
        return flag;
    }
    //保留集合中与指定集合中元素相同的元素
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = true;
        for(Object o:c){
            if(!this.contains(o)){
                flag = flag && remove(o);
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        for (int i=0;i<array.length;i++){
            array[i] = null;
        }
        size=0;
    }

    /**
     * 筛选符合条件的元素
     * @param condition 筛选条件，是一个函数接口
     * @return
     */
    public MyArrayCollection<T> select(Condition<T> condition){
        MyArrayCollection<T> selects = new MyArrayCollection<T>(size);
        for (T item:this){
            if(condition.accept(item)){
                selects.add(item);
            }
        }
        return selects;
    }
    /**
     * 排序
     * @param comparator 比较器，是一个函数接口
     *                   默认实现为：compare(Object o1,Object o2)
     *  return 排序后的集合
     */
    public MyArrayCollection<T> sort(Comparator<T> comparator){
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(array[i], array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return this;
    }
    /**
     * 去重
     * @return 去重后的集合
     */
    public MyArrayCollection<T> distinct(){
        MyArrayCollection<T> result = new MyArrayCollection<T>();
        for (T item:this){
            if(!result.contains(item)){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("自定义集"+ this.getClass().getName()+
                ",容量:" +capacity+
                ",元素:" + size+
                "个\n[");
        for (T item:this) {
            sb.append(item.toString()+"  ");
        }
        sb.append("]");
        return sb.toString();
    }
}
