package cn.jyd.six;

import cn.jyd.eight.Interceptor;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 集合基类.包括集合的基本操作
 *  add：添加元素
 *  remove：删除元素
 *  indexOf：查找元素，返回位置，如没有返回-1
 */
public class BaseCollection<T> implements Iterable<T>  {
    protected Object[] arrays;//存储数据的数组
    protected int size=0;//
    private int capacity;//集合容量

    public BaseCollection(int capacity)
    {
        arrays = new Object[capacity];
    }
    public BaseCollection(){
        arrays= new Object[8];
    }
    //通过数组初始化
    public BaseCollection(T[] arrays){
        size=arrays.length;
        capacity=arrays.length;
        this.arrays=new Object[capacity];
        for(int i=0;i<size;i++){
            this.arrays[i]=arrays[i];
        }
    }
    public void add(T obj)//添加元素
    {
        arrays[size++]=obj;
    }
    public void remove(int index)//删除位置为index的元素
    {
        if(index>=0&&index<size)
        {
            for(int i=index;i<size-1;i++)
            {
                arrays[i]= arrays[i+1];
            }
            arrays[--size]=null;
        }
    }

    public void remove(T obj){
        for(int i=0;i<size;i++)
        {
            if(arrays[i].equals(obj))
            {
                remove(i);
            }
        }
    }
    //查找元素，返回位置，如没有返回-1
    public int indexOf(T obj) {
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
    //判断是否包含某元素
    public boolean contains(T obj){
        return indexOf(obj) != -1;
    }

    public void show()
    {
        System.out.println("集合共有元素："+size+"个");
        for (Object item : arrays) {
            if(item!=null) {
                System.out.print(item.toString() + "\n ");
            }
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int index=0;


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
                return (T) arrays[index++];
            }
        };
    }
//
//    @Override
//    public void forEach(Consumer<? super T> action) {
//        Iterable.super.forEach(action);
//    }
//
//    @Override
//    public Spliterator<T> spliterator() {
//        return Iterable.super.spliterator();
//    }
}
