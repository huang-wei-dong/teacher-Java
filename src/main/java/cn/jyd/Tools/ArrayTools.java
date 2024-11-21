package cn.jyd.Tools;

import cn.jyd.seven.Condition;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayTools<T >{
    private  T[] array;
    public ArrayTools(T[] array){
        this.array = array;
    }
    public ArrayTools(){}
    public void print(){
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i].toString()+" ");
        }
        System.out.println("]");
    }
    public void println(){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i].toString());
        }
    }

    /**
     * 对数组排序
     * @param comparator：比较器
     */
    public void sort(Comparator<T> comparator){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(comparator.compare(array[i],array[j])>0){
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //打印数组
    public static void print(int[] array){
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }
    /**
     * 筛选数组
     * @param condition：筛选条件
     * @return 满足筛选条件的元素构成的数组
     */
    public T[] select(Condition<T> condition){
        ArrayList<T> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(condition.accept(array[i])){
                list.add(array[i]);
                System.out.println(array[i]);
            }
        }
        return list.toArray(array);
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
