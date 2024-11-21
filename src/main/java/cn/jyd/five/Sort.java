package cn.jyd.five;

import java.util.Comparator;

//Comparable<? super T>其中?是通配符，?代表是T的父类，即T是下界
public class Sort <T extends Comparable<? super T>>{

    private T[] arrays;

    public Sort (T[] arrays){
        this.arrays=arrays;
    }
    //冒泡排序
    public void sort(){
        for(int i=0;i<arrays.length;i++){
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[i].compareTo(arrays[j])>0){
                    T temp=arrays[i];
                    arrays[i]=arrays[j];
                    arrays[j]=temp;
                }
            }
        }
    }

    //排序，传入数组和比较器
    public  void sort(Comparator<? super T> comparator){
        for(int i=0;i<arrays.length;i++){
            for(int j=i+1;j<arrays.length;j++){
                if(comparator.compare(arrays[i],arrays[j])>0){
                    T temp=arrays[i];
                    arrays[i]=arrays[j];
                    arrays[j]=temp;
                }
            }
        }
    }
    //显示
    public void show(){
        for(T t:arrays){
            System.out.print(t+"\t");
        }
        System.out.println();
    }
}
